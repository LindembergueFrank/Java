import java.time.Duration;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AgendaManutencoes agenda = new AgendaManutencoes();

        agenda.agendar(new SolicitacaoManutencao(
                "MAN-016",
                TipoManutencao.PREVENTIVA,
                LocalDateTime.of(2026, 9, 15, 8, 0),
                Duration.ofMinutes(90)));

        agenda.buscarPorCodigo("MAN-016").ifPresent(agendamento -> {
            System.out.println("Codigo: " + agendamento.solicitacao().codigo());
            System.out.println("Tipo: " + agendamento.solicitacao().tipo());
            System.out.println("Inicio: " + agendamento.inicio());
            System.out.println("Fim: " + agendamento.fim());
            System.out.println("Status: " + agendamento.status());
        });
    }
}
