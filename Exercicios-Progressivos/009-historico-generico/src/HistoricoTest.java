import java.util.List;

public class HistoricoTest {
    public static void main(String[] args) {
        testarHistoricoDeStrings();
        testarHistoricoDeObjetos();
        testarLimiteDescartaMaisAntigo();
        testarSnapshotImutavel();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarHistoricoDeStrings() {
        Historico<String> historico = new Historico<>(3);
        historico.adicionar("primeiro");
        historico.adicionar("segundo");

        assertEquals(2, historico.tamanho());
        assertEquals("segundo", historico.ultimo());
        assertEquals(List.of("primeiro", "segundo"), historico.listar());
    }

    private static void testarHistoricoDeObjetos() {
        Historico<Evento> historico = new Historico<>(2);
        Evento evento = new Evento("Chamado aberto", "Ana");
        historico.adicionar(evento);

        assertSame(evento, historico.ultimo());
        assertEquals("Chamado aberto", historico.ultimo().getDescricao());
    }

    private static void testarLimiteDescartaMaisAntigo() {
        Historico<Integer> historico = new Historico<>(2);
        historico.adicionar(10);
        historico.adicionar(20);
        historico.adicionar(30);

        assertEquals(List.of(20, 30), historico.listar());
        assertEquals(2, historico.tamanho());
    }

    private static void testarSnapshotImutavel() {
        Historico<String> historico = new Historico<>(2);
        historico.adicionar("item");
        List<String> snapshot = historico.listar();

        assertThrows(UnsupportedOperationException.class, () -> snapshot.add("outro"));
        assertEquals(1, historico.tamanho());
    }

    private static void testarValidacoes() {
        assertThrows(IllegalArgumentException.class, () -> new Historico<String>(0));

        Historico<String> historico = new Historico<>(1);
        assertTrue(historico.estaVazio());
        assertEquals(null, historico.ultimo());
        assertThrows(IllegalArgumentException.class, () -> historico.adicionar(null));
        assertThrows(IllegalArgumentException.class, () -> new Evento(" ", "Ana"));
        assertThrows(IllegalArgumentException.class, () -> new Evento("Aberto", null));
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) {
            throw new AssertionError("Esperado verdadeiro, mas foi falso.");
        }
    }

    private static void assertSame(Object esperado, Object atual) {
        if (esperado != atual) {
            throw new AssertionError("Esperada a mesma referencia de objeto.");
        }
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (esperado == null ? atual != null : !esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipoEsperado, Runnable acao) {
        try {
            acao.run();
        } catch (Throwable erro) {
            if (tipoEsperado.isInstance(erro)) {
                return;
            }
            throw new AssertionError("Excecao inesperada: " + erro.getClass().getSimpleName());
        }
        throw new AssertionError("Era esperada a excecao " + tipoEsperado.getSimpleName());
    }
}
