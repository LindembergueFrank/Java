import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public final class AgendaManutencoes {
    private final List<AgendamentoManutencao> agendamentos = new ArrayList<>();

    public AgendamentoManutencao agendar(SolicitacaoManutencao solicitacao) {
        if (solicitacao == null) {
            throw new IllegalArgumentException("A solicitacao deve ser informada.");
        }
        if (buscarPorCodigo(solicitacao.codigo()).isPresent()) {
            throw new IllegalArgumentException("Ja existe agendamento com o codigo informado.");
        }
        if (existeConflito(solicitacao.inicio(), solicitacao.fim())) {
            throw new IllegalStateException("O periodo solicitado conflita com outro agendamento ativo.");
        }

        AgendamentoManutencao agendamento = new AgendamentoManutencao(solicitacao);
        agendamentos.add(agendamento);
        return agendamento;
    }

    public Optional<AgendamentoManutencao> buscarPorCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return Optional.empty();
        }

        String codigoNormalizado = codigo.trim();
        return agendamentos.stream()
                .filter(agendamento -> agendamento.solicitacao().codigo().equals(codigoNormalizado))
                .findFirst();
    }

    public List<AgendamentoManutencao> listarPorInicio() {
        return agendamentos.stream()
                .sorted(Comparator.comparing(AgendamentoManutencao::inicio))
                .toList();
    }

    private boolean existeConflito(LocalDateTime inicio, LocalDateTime fim) {
        return agendamentos.stream()
                .filter(AgendamentoManutencao::ocupaHorario)
                .anyMatch(existente ->
                        inicio.isBefore(existente.fim()) && fim.isAfter(existente.inicio()));
    }
}
