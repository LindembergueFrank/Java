import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProcessadorPedidoTest {
    public static void main(String[] args) {
        testarProcessamentoOrquestraDependenciasNaOrdemCorreta();
        testarFalhaAoSalvarImpedeNotificacao();
        testarRepositorioMemoriaPreservaPedidosEProtegeColecao();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarProcessamentoOrquestraDependenciasNaOrdemCorreta() {
        List<String> eventos = new ArrayList<>();
        Pedido pedido = novoPedido();
        RepositorioPedidos repositorio = p -> eventos.add("salvar:" + p.getId());
        Notificador notificador = p -> eventos.add("notificar:" + p.getId());

        new ProcessadorPedido(repositorio, notificador).processar(pedido);

        assertEquals(List.of("salvar:PED-001", "notificar:PED-001"), eventos);
    }

    private static void testarFalhaAoSalvarImpedeNotificacao() {
        final boolean[] notificou = {false};
        RepositorioPedidos repositorio = pedido -> {
            throw new IllegalStateException("Falha simulada de persistencia.");
        };
        Notificador notificador = pedido -> notificou[0] = true;
        ProcessadorPedido processador = new ProcessadorPedido(repositorio, notificador);

        assertThrows(IllegalStateException.class, () -> processador.processar(novoPedido()));
        assertFalse(notificou[0]);
    }

    private static void testarRepositorioMemoriaPreservaPedidosEProtegeColecao() {
        RepositorioPedidosMemoria repositorio = new RepositorioPedidosMemoria();
        Pedido pedido = novoPedido();
        repositorio.salvar(pedido);

        List<Pedido> pedidos = repositorio.listar();
        assertEquals(List.of(pedido), pedidos);
        assertThrows(UnsupportedOperationException.class, () -> pedidos.add(novoPedido()));
    }

    private static void testarValidacoes() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pedido(" ", "Ana", new BigDecimal("10.00")));
        assertThrows(IllegalArgumentException.class,
                () -> new Pedido("PED-001", " ", new BigDecimal("10.00")));
        assertThrows(IllegalArgumentException.class,
                () -> new Pedido("PED-001", "Ana", BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class,
                () -> new ProcessadorPedido(null, pedido -> {}));
        assertThrows(IllegalArgumentException.class,
                () -> new ProcessadorPedido(pedido -> {}, null));

        ProcessadorPedido processador = new ProcessadorPedido(pedido -> {}, pedido -> {});
        assertThrows(IllegalArgumentException.class, () -> processador.processar(null));
    }

    private static Pedido novoPedido() {
        return new Pedido("PED-001", "Ana", new BigDecimal("349.90"));
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (!esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertFalse(boolean condicao) {
        if (condicao) {
            throw new AssertionError("A condicao deveria ser falsa.");
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipo, Executavel executavel) {
        try {
            executavel.executar();
        } catch (Throwable erro) {
            if (tipo.isInstance(erro)) {
                return;
            }
            throw new AssertionError("Excecao inesperada: " + erro.getClass().getName(), erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipo.getName());
    }

    @FunctionalInterface
    private interface Executavel {
        void executar();
    }
}
