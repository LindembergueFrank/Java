import java.time.Duration;
import java.time.Instant;

public class LimiteRequisicoesTest {
    private static final Instant INICIO = Instant.parse("2026-01-01T10:00:00Z");

    public static void main(String[] args) {
        deveRespeitarLimite();
        deveExpirarRegistrosAntigos();
        deveExpirarNaFronteiraExata();
        deveIsolarClientes();
        deveConsultarSomenteRequisicoesAtivas();
        deveValidarConfiguracaoECliente();
        System.out.println("Todos os testes passaram.");
    }

    private static void deveRespeitarLimite() {
        RelogioAjustavel relogio = new RelogioAjustavel(INICIO);
        LimiteRequisicoes limite = new LimiteRequisicoes(2, Duration.ofSeconds(10), relogio);

        assertTrue(limite.tentar("cliente-a"));
        assertTrue(limite.tentar("cliente-a"));
        assertFalse(limite.tentar("cliente-a"));
        assertEquals(2, limite.requisicoesAtivas("cliente-a"));
    }

    private static void deveExpirarRegistrosAntigos() {
        RelogioAjustavel relogio = new RelogioAjustavel(INICIO);
        LimiteRequisicoes limite = new LimiteRequisicoes(2, Duration.ofSeconds(10), relogio);

        limite.tentar("cliente");
        relogio.avancar(Duration.ofSeconds(5));
        limite.tentar("cliente");
        relogio.avancar(Duration.ofSeconds(6));

        assertEquals(1, limite.requisicoesAtivas("cliente"));
        assertTrue(limite.tentar("cliente"));
    }

    private static void deveExpirarNaFronteiraExata() {
        RelogioAjustavel relogio = new RelogioAjustavel(INICIO);
        LimiteRequisicoes limite = new LimiteRequisicoes(1, Duration.ofSeconds(10), relogio);

        assertTrue(limite.tentar("cliente"));
        relogio.avancar(Duration.ofSeconds(10));
        assertTrue(limite.tentar("cliente"));
        assertEquals(1, limite.requisicoesAtivas("cliente"));
    }

    private static void deveIsolarClientes() {
        RelogioAjustavel relogio = new RelogioAjustavel(INICIO);
        LimiteRequisicoes limite = new LimiteRequisicoes(1, Duration.ofMinutes(1), relogio);

        assertTrue(limite.tentar("a"));
        assertFalse(limite.tentar("a"));
        assertTrue(limite.tentar("b"));
    }

    private static void deveConsultarSomenteRequisicoesAtivas() {
        RelogioAjustavel relogio = new RelogioAjustavel(INICIO);
        LimiteRequisicoes limite = new LimiteRequisicoes(3, Duration.ofSeconds(2), relogio);

        assertEquals(0, limite.requisicoesAtivas("novo"));
        limite.tentar("cliente");
        relogio.avancar(Duration.ofSeconds(3));
        assertEquals(0, limite.requisicoesAtivas("cliente"));
    }

    private static void deveValidarConfiguracaoECliente() {
        RelogioAjustavel relogio = new RelogioAjustavel(INICIO);
        assertThrows(IllegalArgumentException.class, () -> new LimiteRequisicoes(0, Duration.ofSeconds(1), relogio));
        assertThrows(IllegalArgumentException.class, () -> new LimiteRequisicoes(1, Duration.ZERO, relogio));
        assertThrows(IllegalArgumentException.class, () -> new LimiteRequisicoes(1, Duration.ofSeconds(1), null));

        LimiteRequisicoes limite = new LimiteRequisicoes(1, Duration.ofSeconds(1), relogio);
        assertThrows(IllegalArgumentException.class, () -> limite.tentar(" "));
        assertThrows(IllegalArgumentException.class, () -> limite.requisicoesAtivas(null));
        assertThrows(IllegalArgumentException.class, () -> relogio.avancar(Duration.ofSeconds(-1)));
    }

    private static void assertEquals(int esperado, int atual) {
        if (esperado != atual) throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) throw new AssertionError("A condicao esperada era verdadeira.");
    }

    private static void assertFalse(boolean condicao) {
        if (condicao) throw new AssertionError("A condicao esperada era falsa.");
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
