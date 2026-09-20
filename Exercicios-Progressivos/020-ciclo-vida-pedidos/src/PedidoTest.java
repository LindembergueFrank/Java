import java.math.BigDecimal;
import java.time.Instant;

public class PedidoTest {
    public static void main(String[] args) {
        testarFluxoCompleto();
        testarConfirmacaoSemItens();
        testarPagamentoIncorreto();
        testarTransicoesInvalidas();
        testarCancelamento();
        testarImutabilidadeDaLista();
        testarInvariantes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarFluxoCompleto() {
        Pedido pedido = pedidoComItem();
        assertEquals(new BigDecimal("25.00"), pedido.total());
        pedido.confirmar();
        pedido.pagar(new BigDecimal("25.00"), Instant.parse("2026-09-20T12:00:00Z"));
        assertEquals(StatusPedido.PAGO, pedido.status());
        assertTrue(pedido.pagamento().isPresent());
    }

    private static void testarConfirmacaoSemItens() {
        Pedido pedido = new Pedido("P-2");
        assertThrows(IllegalStateException.class, pedido::confirmar);
    }

    private static void testarPagamentoIncorreto() {
        Pedido pedido = pedidoComItem();
        pedido.confirmar();
        assertThrows(IllegalArgumentException.class, () -> pedido.pagar(new BigDecimal("24.99"), Instant.EPOCH));
        assertEquals(StatusPedido.CONFIRMADO, pedido.status());
    }

    private static void testarTransicoesInvalidas() {
        Pedido pedido = pedidoComItem();
        assertThrows(IllegalStateException.class, () -> pedido.pagar(new BigDecimal("25.00"), Instant.EPOCH));
        pedido.confirmar();
        assertThrows(IllegalStateException.class, () -> pedido.adicionarItem(item()));
        pedido.pagar(new BigDecimal("25.00"), Instant.EPOCH);
        assertThrows(IllegalStateException.class, pedido::cancelar);
        assertThrows(IllegalStateException.class, pedido::confirmar);
    }

    private static void testarCancelamento() {
        Pedido rascunho = pedidoComItem();
        rascunho.cancelar();
        assertEquals(StatusPedido.CANCELADO, rascunho.status());

        Pedido confirmado = pedidoComItem();
        confirmado.confirmar();
        confirmado.cancelar();
        assertEquals(StatusPedido.CANCELADO, confirmado.status());
    }

    private static void testarImutabilidadeDaLista() {
        Pedido pedido = pedidoComItem();
        assertThrows(UnsupportedOperationException.class, () -> pedido.itens().add(item()));
    }

    private static void testarInvariantes() {
        assertThrows(IllegalArgumentException.class, () -> new Pedido(" "));
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido(" ", 1, BigDecimal.ONE));
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido("Item", 0, BigDecimal.ONE));
        assertThrows(IllegalArgumentException.class, () -> new ItemPedido("Item", 1, BigDecimal.ZERO));
    }

    private static Pedido pedidoComItem() {
        Pedido pedido = new Pedido("P-020");
        pedido.adicionarItem(item());
        return pedido;
    }

    private static ItemPedido item() {
        return new ItemPedido("Cabo de rede", 2, new BigDecimal("12.50"));
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (!esperado.equals(atual)) throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) throw new AssertionError("A condicao esperada era verdadeira.");
    }

    private static void assertThrows(Class<? extends Throwable> tipo, Executavel executavel) {
        try { executavel.executar(); }
        catch (Throwable erro) {
            if (tipo.isInstance(erro)) return;
            throw new AssertionError("Excecao inesperada: " + erro.getClass().getName(), erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipo.getName());
    }

    @FunctionalInterface
    private interface Executavel { void executar(); }
}
