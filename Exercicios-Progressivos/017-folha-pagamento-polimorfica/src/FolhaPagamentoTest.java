import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FolhaPagamentoTest {
    public static void main(String[] args) {
        testarCalculoMensalista();
        testarCalculoHorista();
        testarPolimorfismoNaMesmaColecao();
        testarNovaSubclasseSemAlterarFolha();
        testarResumoImutavel();
        testarValidacoes();

        System.out.println("Todos os testes passaram.");
    }

    private static void testarCalculoMensalista() {
        Funcionario funcionario = new FuncionarioMensalista(
                "F001",
                "Ana",
                new BigDecimal("3500.00"),
                new BigDecimal("450.75"));

        assertBigDecimalEquals(new BigDecimal("3950.75"), funcionario.calcularPagamento());
    }

    private static void testarCalculoHorista() {
        Funcionario funcionario = new FuncionarioHorista(
                "F002",
                "Bruno",
                new BigDecimal("42.50"),
                120);

        assertBigDecimalEquals(new BigDecimal("5100.00"), funcionario.calcularPagamento());
    }

    private static void testarPolimorfismoNaMesmaColecao() {
        List<Funcionario> funcionarios = List.of(
                new FuncionarioMensalista(
                        "F001", "Ana", new BigDecimal("3000.00"), new BigDecimal("200.00")),
                new FuncionarioHorista(
                        "F002", "Bruno", new BigDecimal("50.00"), 80));

        BigDecimal total = new FolhaPagamento().calcularTotal(funcionarios);

        assertBigDecimalEquals(new BigDecimal("7200.00"), total);
    }

    private static void testarNovaSubclasseSemAlterarFolha() {
        Funcionario bolsista = new Funcionario("F003", "Carla") {
            @Override
            public BigDecimal calcularPagamento() {
                return monetario(new BigDecimal("1800.00"));
            }
        };

        BigDecimal total = new FolhaPagamento().calcularTotal(List.of(bolsista));

        assertBigDecimalEquals(new BigDecimal("1800.00"), total);
    }

    private static void testarResumoImutavel() {
        List<ResumoPagamento> resumos = new FolhaPagamento().gerarResumos(List.of(
                new FuncionarioMensalista(
                        "F001", "Ana", new BigDecimal("3000.00"), BigDecimal.ZERO)));

        assertEquals("F001", resumos.get(0).matricula());
        assertBigDecimalEquals(new BigDecimal("3000.00"), resumos.get(0).valor());
        assertThrows(UnsupportedOperationException.class, () ->
                resumos.add(new ResumoPagamento("F999", "Teste", BigDecimal.ZERO)));
    }

    private static void testarValidacoes() {
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioMensalista(
                        " ", "Ana", new BigDecimal("3000.00"), BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioMensalista(
                        "F001", " ", new BigDecimal("3000.00"), BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioMensalista(
                        "F001", "Ana", BigDecimal.ZERO, BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioMensalista(
                        "F001", "Ana", new BigDecimal("3000.00"), new BigDecimal("-1")));
        assertThrows(IllegalArgumentException.class, () ->
                new FuncionarioHorista(
                        "F002", "Bruno", new BigDecimal("50.00"), 221));
        assertThrows(IllegalArgumentException.class, () ->
                new FolhaPagamento().calcularTotal(null));

        List<Funcionario> comNulo = new ArrayList<>();
        comNulo.add(null);
        assertThrows(IllegalArgumentException.class, () ->
                new FolhaPagamento().calcularTotal(comNulo));
    }

    private static void assertBigDecimalEquals(BigDecimal esperado, BigDecimal atual) {
        if (esperado.compareTo(atual) != 0) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (!esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
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
