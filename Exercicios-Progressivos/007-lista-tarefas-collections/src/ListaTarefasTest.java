import java.util.List;

public class ListaTarefasTest {
    public static void main(String[] args) {
        testarCadastroEBusca();
        testarConclusao();
        testarPendentes();
        testarEncapsulamentoDaColecao();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarCadastroEBusca() {
        ListaTarefas lista = new ListaTarefas();
        lista.adicionar(new Tarefa("Estudar Collections"));
        lista.adicionar(new Tarefa("Revisar POO"));

        assertEquals(2, lista.quantidade());
        assertEquals("Estudar Collections", lista.buscarPorTitulo("estudar collections").getTitulo());
        assertNull(lista.buscarPorTitulo("Inexistente"));
    }

    private static void testarConclusao() {
        ListaTarefas lista = new ListaTarefas();
        Tarefa tarefa = new Tarefa("Praticar List");
        lista.adicionar(tarefa);

        assertTrue(lista.concluir("Praticar List"));
        assertTrue(tarefa.isConcluida());
        assertFalse(lista.concluir("Outra tarefa"));
    }

    private static void testarPendentes() {
        ListaTarefas lista = new ListaTarefas();
        lista.adicionar(new Tarefa("A"));
        lista.adicionar(new Tarefa("B"));
        lista.adicionar(new Tarefa("C"));
        lista.concluir("B");

        List<Tarefa> pendentes = lista.listarPendentes();
        assertEquals(2, pendentes.size());
        assertEquals("A", pendentes.get(0).getTitulo());
        assertEquals("C", pendentes.get(1).getTitulo());
    }

    private static void testarEncapsulamentoDaColecao() {
        ListaTarefas lista = new ListaTarefas();
        lista.adicionar(new Tarefa("Protegida"));
        List<Tarefa> snapshot = lista.listarTodas();

        assertThrowsUnsupported(() -> snapshot.add(new Tarefa("Externa")));
        assertEquals(1, lista.quantidade());
    }

    private static void testarValidacoes() {
        assertThrowsIllegalArgument(() -> new Tarefa("   "));

        ListaTarefas lista = new ListaTarefas();
        assertThrowsIllegalArgument(() -> lista.adicionar(null));
        assertNull(lista.buscarPorTitulo(" "));
    }

    private static void assertEquals(int esperado, int atual) {
        if (esperado != atual) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertEquals(String esperado, String atual) {
        if (!esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertTrue(boolean valor) {
        if (!valor) {
            throw new AssertionError("Esperado verdadeiro, mas foi falso.");
        }
    }

    private static void assertFalse(boolean valor) {
        if (valor) {
            throw new AssertionError("Esperado falso, mas foi verdadeiro.");
        }
    }

    private static void assertNull(Object valor) {
        if (valor != null) {
            throw new AssertionError("Esperado null, mas recebeu: " + valor);
        }
    }

    private static void assertThrowsIllegalArgument(Runnable acao) {
        try {
            acao.run();
            throw new AssertionError("Era esperada IllegalArgumentException.");
        } catch (IllegalArgumentException expected) {
            // comportamento esperado
        }
    }

    private static void assertThrowsUnsupported(Runnable acao) {
        try {
            acao.run();
            throw new AssertionError("Era esperada UnsupportedOperationException.");
        } catch (UnsupportedOperationException expected) {
            // comportamento esperado
        }
    }
}
