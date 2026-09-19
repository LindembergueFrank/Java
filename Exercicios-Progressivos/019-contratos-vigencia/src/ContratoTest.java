import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class ContratoTest {
    public static void main(String[] args) {
        testarSituacoesPorData();
        testarContratoSemFimPrevisto();
        testarEncerramentoAntecipado();
        testarTempoDecorrido();
        testarInvariantes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarSituacoesPorData() {
        Contrato contrato = contrato("2026-01-10", "2026-12-31");
        assertEquals(SituacaoContrato.AGUARDANDO_INICIO, contrato.situacaoEm(data("2026-01-09")));
        assertEquals(SituacaoContrato.ATIVO, contrato.situacaoEm(data("2026-01-10")));
        assertEquals(SituacaoContrato.ATIVO, contrato.situacaoEm(data("2026-12-31")));
        assertEquals(SituacaoContrato.ENCERRADO, contrato.situacaoEm(data("2027-01-01")));
    }

    private static void testarContratoSemFimPrevisto() {
        Contrato contrato = contrato("2026-01-10", null);
        assertTrue(contrato.dados().fimPrevistoOpcional().isEmpty());
        assertTrue(contrato.dataEfetivaFim().isEmpty());
        assertEquals(SituacaoContrato.ATIVO, contrato.situacaoEm(data("2030-01-01")));
    }

    private static void testarEncerramentoAntecipado() {
        Contrato contrato = contrato("2026-01-10", "2026-12-31");
        contrato.encerrarEm(data("2026-06-30"));
        assertEquals(data("2026-06-30"), contrato.encerramentoAntecipado().orElseThrow());
        assertEquals(SituacaoContrato.ATIVO, contrato.situacaoEm(data("2026-06-30")));
        assertEquals(SituacaoContrato.ENCERRADO, contrato.situacaoEm(data("2026-07-01")));
        assertThrows(IllegalStateException.class, () -> contrato.encerrarEm(data("2026-07-10")));
    }

    private static void testarTempoDecorrido() {
        Contrato contrato = contrato("2026-01-10", "2026-12-31");
        assertEquals(Period.ZERO, contrato.tempoDecorridoAte(data("2026-01-01")));
        assertEquals(Period.ofMonths(2), contrato.tempoDecorridoAte(data("2026-03-10")));
        contrato.encerrarEm(data("2026-04-10"));
        assertEquals(Period.ofMonths(3), contrato.tempoDecorridoAte(data("2027-01-01")));
    }

    private static void testarInvariantes() {
        assertThrows(IllegalArgumentException.class, () -> new DadosContrato(
                " ", data("2026-01-10"), null, new BigDecimal("100.00")));
        assertThrows(IllegalArgumentException.class, () -> new DadosContrato(
                "C-1", data("2026-01-10"), data("2026-01-09"), new BigDecimal("100.00")));
        assertThrows(IllegalArgumentException.class, () -> new DadosContrato(
                "C-1", data("2026-01-10"), null, BigDecimal.ZERO));
        Contrato contrato = contrato("2026-01-10", "2026-12-31");
        assertThrows(IllegalArgumentException.class, () -> contrato.encerrarEm(data("2026-01-09")));
        assertThrows(IllegalArgumentException.class, () -> contrato.encerrarEm(data("2027-01-01")));
    }

    private static Contrato contrato(String inicio, String fim) {
        return new Contrato(new DadosContrato(
                "CTR-019",
                data(inicio),
                fim == null ? null : data(fim),
                new BigDecimal("1250.90")));
    }

    private static LocalDate data(String valor) {
        return LocalDate.parse(valor);
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (!esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) {
            throw new AssertionError("A condicao esperada era verdadeira.");
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipo, Executavel executavel) {
        try {
            executavel.executar();
        } catch (Throwable erro) {
            if (tipo.isInstance(erro)) return;
            throw new AssertionError("Excecao inesperada: " + erro.getClass().getName(), erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipo.getName());
    }

    @FunctionalInterface
    private interface Executavel {
        void executar();
    }
}
