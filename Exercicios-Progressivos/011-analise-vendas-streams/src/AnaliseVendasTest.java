import java.util.List;
import java.util.Map;

public class AnaliseVendasTest {
    public static void main(String[] args) {
        testarPipelineFiltroOrdenacaoMap();
        testarReducaoNumerica();
        testarAgrupamentoPorCategoria();
        testarEstadoOriginalPreservado();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarPipelineFiltroOrdenacaoMap() {
        List<String> produtos = novaAnalise().produtosAcimaDe(300.00);

        assertEquals(List.of("Notebook", "Monitor", "Headset"), produtos);
        assertThrows(UnsupportedOperationException.class, () -> produtos.add("Outro"));
    }

    private static void testarReducaoNumerica() {
        assertDoubleEquals(6045.00, novaAnalise().totalVendido());
    }

    private static void testarAgrupamentoPorCategoria() {
        Map<String, Double> totais = novaAnalise().totalPorCategoria();

        assertDoubleEquals(595.00, totais.get("Perifericos"));
        assertDoubleEquals(1250.00, totais.get("Monitores"));
        assertDoubleEquals(4200.00, totais.get("Computadores"));
        assertEquals(
                List.of("Perifericos", "Monitores", "Computadores"),
                List.copyOf(totais.keySet()));
    }

    private static void testarEstadoOriginalPreservado() {
        AnaliseVendas analise = novaAnalise();
        List<Venda> antes = analise.listar();

        analise.produtosAcimaDe(100.00);
        analise.totalPorCategoria();

        assertEquals(antes, analise.listar());
        assertThrows(UnsupportedOperationException.class, () -> analise.listar().clear());
    }

    private static void testarValidacoes() {
        assertThrows(IllegalArgumentException.class, () -> new AnaliseVendas(null));
        assertThrows(
                IllegalArgumentException.class,
                () -> new AnaliseVendas(java.util.Arrays.asList(
                        new Venda("Mouse", "Perifericos", 50.00), null)));
        assertThrows(IllegalArgumentException.class, () -> new Venda(" ", "Perifericos", 10.00));
        assertThrows(IllegalArgumentException.class, () -> new Venda("Mouse", null, 10.00));
        assertThrows(IllegalArgumentException.class, () -> new Venda("Mouse", "Perifericos", -1.00));
    }

    private static AnaliseVendas novaAnalise() {
        return new AnaliseVendas(List.of(
                new Venda("Teclado", "Perifericos", 180.00),
                new Venda("Monitor", "Monitores", 1250.00),
                new Venda("Mouse", "Perifericos", 95.00),
                new Venda("Notebook", "Computadores", 4200.00),
                new Venda("Headset", "Perifericos", 320.00)));
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (esperado == null ? atual != null : !esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertDoubleEquals(double esperado, double atual) {
        if (Math.abs(esperado - atual) > 0.000001) {
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
            throw new AssertionError("Excecao inesperada: " + erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipoEsperado.getSimpleName());
    }
}
