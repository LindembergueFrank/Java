public class ItemEstoqueTest {
    public static void main(String[] args) throws Exception {
        testarEntradaESaidaDeEstoque();
        testarExcecaoDeEstoqueInsuficiente();
        testarEstadoPreservadoAposFalha();
        testarDadosDaExcecao();
        testarValidacoesDeEntrada();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarEntradaESaidaDeEstoque() throws Exception {
        ItemEstoque item = new ItemEstoque("Mouse", 10);
        item.adicionar(5);
        item.retirar(3);
        assertEquals(12, item.getQuantidade());
    }

    private static void testarExcecaoDeEstoqueInsuficiente() {
        ItemEstoque item = new ItemEstoque("Monitor", 2);
        assertThrows(EstoqueInsuficienteException.class, () -> item.retirar(3));
    }

    private static void testarEstadoPreservadoAposFalha() {
        ItemEstoque item = new ItemEstoque("Headset", 4);
        assertThrows(EstoqueInsuficienteException.class, () -> item.retirar(7));
        assertEquals(4, item.getQuantidade());
    }

    private static void testarDadosDaExcecao() {
        ItemEstoque item = new ItemEstoque("Webcam", 1);
        try {
            item.retirar(2);
            throw new AssertionError("Era esperada EstoqueInsuficienteException.");
        } catch (EstoqueInsuficienteException erro) {
            assertEquals("Webcam", erro.getProduto());
            assertEquals(2, erro.getSolicitado());
            assertEquals(1, erro.getDisponivel());
        }
    }

    private static void testarValidacoesDeEntrada() {
        assertThrows(IllegalArgumentException.class, () -> new ItemEstoque(" ", 1));
        assertThrows(IllegalArgumentException.class, () -> new ItemEstoque("Mouse", -1));

        ItemEstoque item = new ItemEstoque("Mouse", 1);
        assertThrows(IllegalArgumentException.class, () -> item.adicionar(0));
        assertThrows(IllegalArgumentException.class, () -> item.retirar(-1));
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (esperado == null ? atual != null : !esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipoEsperado, AcaoComExcecao acao) {
        try {
            acao.executar();
        } catch (Throwable erro) {
            if (tipoEsperado.isInstance(erro)) {
                return;
            }
            throw new AssertionError("Excecao inesperada: " + erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipoEsperado.getSimpleName());
    }

    @FunctionalInterface
    private interface AcaoComExcecao {
        void executar() throws Exception;
    }
}
