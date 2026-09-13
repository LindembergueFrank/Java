import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class AgendaManutencoesTest {
    public static void main(String[] args) {
        testarAgendamentoEConsultaComOptional();
        testarOrdenacaoCronologica();
        testarConflitoDeHorario();
        testarLimitesAdjacentesSemConflito();
        testarCancelamentoLiberaHorario();
        testarTransicoesDeStatus();
        testarValidacoesDoRecord();
        testarCodigoDuplicado();

        System.out.println("Todos os testes passaram.");
    }

    private static void testarAgendamentoEConsultaComOptional() {
        AgendaManutencoes agenda = new AgendaManutencoes();
        AgendamentoManutencao agendamento = agenda.agendar(solicitacao(
                "MAN-001", TipoManutencao.PREVENTIVA, "2026-09-15T08:00", 90));

        assertEquals(StatusAgendamento.AGENDADO, agendamento.status());
        assertTrue(agenda.buscarPorCodigo("MAN-001").isPresent());
        assertTrue(agenda.buscarPorCodigo("INEXISTENTE").isEmpty());
        assertTrue(agenda.buscarPorCodigo(" ").isEmpty());
    }

    private static void testarOrdenacaoCronologica() {
        AgendaManutencoes agenda = new AgendaManutencoes();
        agenda.agendar(solicitacao("MAN-002", TipoManutencao.INSPECAO, "2026-09-15T14:00", 60));
        agenda.agendar(solicitacao("MAN-001", TipoManutencao.PREVENTIVA, "2026-09-15T08:00", 60));

        List<AgendamentoManutencao> ordenados = agenda.listarPorInicio();

        assertEquals("MAN-001", ordenados.get(0).solicitacao().codigo());
        assertEquals("MAN-002", ordenados.get(1).solicitacao().codigo());
        assertThrows(UnsupportedOperationException.class, () -> ordenados.add(
                new AgendamentoManutencao(solicitacao(
                        "MAN-003", TipoManutencao.CORRETIVA, "2026-09-16T08:00", 60))));
    }

    private static void testarConflitoDeHorario() {
        AgendaManutencoes agenda = new AgendaManutencoes();
        agenda.agendar(solicitacao("MAN-001", TipoManutencao.PREVENTIVA, "2026-09-15T08:00", 120));

        assertThrows(IllegalStateException.class, () ->
                agenda.agendar(solicitacao(
                        "MAN-002", TipoManutencao.CORRETIVA, "2026-09-15T09:30", 60)));
    }

    private static void testarLimitesAdjacentesSemConflito() {
        AgendaManutencoes agenda = new AgendaManutencoes();
        agenda.agendar(solicitacao("MAN-001", TipoManutencao.PREVENTIVA, "2026-09-15T08:00", 60));
        agenda.agendar(solicitacao("MAN-002", TipoManutencao.INSPECAO, "2026-09-15T09:00", 30));

        assertEquals(2, agenda.listarPorInicio().size());
    }

    private static void testarCancelamentoLiberaHorario() {
        AgendaManutencoes agenda = new AgendaManutencoes();
        AgendamentoManutencao primeiro = agenda.agendar(
                solicitacao("MAN-001", TipoManutencao.PREVENTIVA, "2026-09-15T08:00", 60));

        primeiro.cancelar();

        agenda.agendar(solicitacao(
                "MAN-002", TipoManutencao.CORRETIVA, "2026-09-15T08:30", 30));

        assertEquals(StatusAgendamento.CANCELADO, primeiro.status());
        assertEquals(2, agenda.listarPorInicio().size());
    }

    private static void testarTransicoesDeStatus() {
        AgendamentoManutencao concluido = new AgendamentoManutencao(
                solicitacao("MAN-001", TipoManutencao.PREVENTIVA, "2026-09-15T08:00", 60));
        concluido.concluir();

        assertEquals(StatusAgendamento.CONCLUIDO, concluido.status());
        assertThrows(IllegalStateException.class, concluido::cancelar);

        AgendamentoManutencao cancelado = new AgendamentoManutencao(
                solicitacao("MAN-002", TipoManutencao.INSPECAO, "2026-09-15T10:00", 60));
        cancelado.cancelar();

        assertThrows(IllegalStateException.class, cancelado::concluir);
    }

    private static void testarValidacoesDoRecord() {
        LocalDateTime inicio = LocalDateTime.parse("2026-09-15T08:00");

        assertThrows(IllegalArgumentException.class, () ->
                new SolicitacaoManutencao(" ", TipoManutencao.PREVENTIVA, inicio, Duration.ofMinutes(30)));
        assertThrows(IllegalArgumentException.class, () ->
                new SolicitacaoManutencao("MAN", null, inicio, Duration.ofMinutes(30)));
        assertThrows(IllegalArgumentException.class, () ->
                new SolicitacaoManutencao("MAN", TipoManutencao.PREVENTIVA, null, Duration.ofMinutes(30)));
        assertThrows(IllegalArgumentException.class, () ->
                new SolicitacaoManutencao("MAN", TipoManutencao.PREVENTIVA, inicio, Duration.ZERO));
    }

    private static void testarCodigoDuplicado() {
        AgendaManutencoes agenda = new AgendaManutencoes();
        agenda.agendar(solicitacao("MAN-001", TipoManutencao.PREVENTIVA, "2026-09-15T08:00", 60));

        assertThrows(IllegalArgumentException.class, () ->
                agenda.agendar(solicitacao(
                        " MAN-001 ", TipoManutencao.INSPECAO, "2026-09-15T10:00", 30)));
    }

    private static SolicitacaoManutencao solicitacao(
            String codigo, TipoManutencao tipo, String inicio, long minutos) {
        return new SolicitacaoManutencao(
                codigo,
                tipo,
                LocalDateTime.parse(inicio),
                Duration.ofMinutes(minutos));
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
