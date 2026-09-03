public class ProdutoTest {
    public static void main(String[] args) {
        testarCriacaoEConsultas();
        testarMovimentacoesDeEstoque();
        testarSaidaSemEstoqueSuficiente();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarCriacaoEConsultas() {
        Produto produto = new Produto("Teclado", 120.50, 10);

        assertEquals("Teclado", produto.getNome());
        assertEquals(120.50, produto.getPreco(), 0.0001);
        assertEquals(10, produto.getQuantidade());
        assertEquals(1205.00, produto.calcularValorTotal(), 0.0001);
    }

    private static void testarMovimentacoesDeEstoque() {
        Produto produto = new Produto("Mouse", 80.00, 5);

        produto.adicionarEstoque(3);
        assertEquals(8, produto.getQuantidade());

        assertTrue(produto.removerEstoque(2));
        assertEquals(6, produto.getQuantidade());
        assertEquals(480.00, produto.calcularValorTotal(), 0.0001);
    }

    private static void testarSaidaSemEstoqueSuficiente() {
        Produto produto = new Produto("Monitor", 900.00, 2);

        assertFalse(produto.removerEstoque(3));
        assertEquals(2, produto.getQuantidade());
    }

    private static void testarValidacoes() {
        assertThrows(() -> new Produto("   ", 10.00, 1));
        assertThrows(() -> new Produto("Cabo", 0.00, 1));
        assertThrows(() -> new Produto("Cabo", 10.00, -1));

        Produto produto = new Produto("Cabo", 10.00, 1);
        assertThrows(() -> produto.adicionarEstoque(0));
        assertThrows(() -> produto.removerEstoque(-1));
    }

    private static void assertEquals(String esperado, String atual) {
        if (!esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertEquals(int esperado, int atual) {
        if (esperado != atual) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertEquals(double esperado, double atual, double tolerancia) {
        if (Math.abs(esperado - atual) > tolerancia) {
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

    private static void assertThrows(Runnable acao) {
        try {
            acao.run();
            throw new AssertionError("Era esperada IllegalArgumentException.");
        } catch (IllegalArgumentException expected) {
            // comportamento esperado
        }
    }
}
