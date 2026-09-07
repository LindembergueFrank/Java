import java.util.Comparator;
import java.util.List;

public class RelatorioVendasTest {
    public static void main(String[] args) {
        testarFiltroComLambda();
        testarOrdenacaoComComparator();
        testarEstadoOriginalPreservado();
        testarSnapshotsImutaveis();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarFiltroComLambda() {
        RelatorioVendas relatorio = novoRelatorio();

        List<RegistroVenda> vendasAna = relatorio.filtrar(
                venda -> venda.getVendedor().equals("Ana"));
        List<RegistroVenda> vendasCaras = relatorio.filtrar(
                venda -> venda.getValor() >= 1000.00);

        assertEquals(2, vendasAna.size());
        assertEquals("Teclado", vendasAna.get(0).getProduto());
        assertEquals("Mouse", vendasAna.get(1).getProduto());
        assertEquals("Monitor", vendasCaras.get(0).getProduto());
        assertEquals("Notebook", vendasCaras.get(1).getProduto());
    }

    private static void testarOrdenacaoComComparator() {
        RelatorioVendas relatorio = novoRelatorio();

        List<RegistroVenda> porValor = relatorio.ordenar(
                Comparator.comparingDouble(RegistroVenda::getValor));
        List<RegistroVenda> porProduto = relatorio.ordenar(
                Comparator.comparing(RegistroVenda::getProduto));

        assertEquals("Mouse", porValor.get(0).getProduto());
        assertEquals("Notebook", porValor.get(3).getProduto());
        assertEquals("Monitor", porProduto.get(0).getProduto());
        assertEquals("Teclado", porProduto.get(3).getProduto());
    }

    private static void testarEstadoOriginalPreservado() {
        RelatorioVendas relatorio = novoRelatorio();
        List<RegistroVenda> antes = relatorio.listar();

        relatorio.filtrar(venda -> venda.getValor() > 100.00);
        relatorio.ordenar(Comparator.comparingDouble(RegistroVenda::getValor));

        assertEquals(antes, relatorio.listar());
        assertEquals("Teclado", relatorio.listar().get(0).getProduto());
    }

    private static void testarSnapshotsImutaveis() {
        RelatorioVendas relatorio = novoRelatorio();

        assertThrows(UnsupportedOperationException.class,
                () -> relatorio.listar().add(new RegistroVenda("Webcam", "Davi", 250.00)));
        assertThrows(UnsupportedOperationException.class,
                () -> relatorio.filtrar(venda -> true).clear());
    }

    private static void testarValidacoes() {
        assertThrows(IllegalArgumentException.class, () -> new RelatorioVendas(null));
        assertThrows(IllegalArgumentException.class,
                () -> new RelatorioVendas(java.util.Arrays.asList(new RegistroVenda("Mouse", "Ana", 50.00), null)));

        RelatorioVendas relatorio = novoRelatorio();
        assertThrows(IllegalArgumentException.class, () -> relatorio.filtrar(null));
        assertThrows(IllegalArgumentException.class, () -> relatorio.ordenar(null));
        assertThrows(IllegalArgumentException.class, () -> new RegistroVenda(" ", "Ana", 10.00));
        assertThrows(IllegalArgumentException.class, () -> new RegistroVenda("Mouse", null, 10.00));
        assertThrows(IllegalArgumentException.class, () -> new RegistroVenda("Mouse", "Ana", -1.00));
    }

    private static RelatorioVendas novoRelatorio() {
        return new RelatorioVendas(List.of(
                new RegistroVenda("Teclado", "Ana", 180.00),
                new RegistroVenda("Monitor", "Bruno", 1250.00),
                new RegistroVenda("Mouse", "Ana", 95.00),
                new RegistroVenda("Notebook", "Carla", 4200.00)));
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
