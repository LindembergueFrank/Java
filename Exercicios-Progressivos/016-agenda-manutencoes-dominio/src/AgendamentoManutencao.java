import java.time.LocalDateTime;

public final class AgendamentoManutencao {
    private final SolicitacaoManutencao solicitacao;
    private StatusAgendamento status;

    public AgendamentoManutencao(SolicitacaoManutencao solicitacao) {
        if (solicitacao == null) {
            throw new IllegalArgumentException("A solicitacao deve ser informada.");
        }
        this.solicitacao = solicitacao;
        this.status = StatusAgendamento.AGENDADO;
    }

    public SolicitacaoManutencao solicitacao() {
        return solicitacao;
    }

    public StatusAgendamento status() {
        return status;
    }

    public LocalDateTime inicio() {
        return solicitacao.inicio();
    }

    public LocalDateTime fim() {
        return solicitacao.fim();
    }

    public void concluir() {
        exigirStatusAgendado("concluir");
        status = StatusAgendamento.CONCLUIDO;
    }

    public void cancelar() {
        exigirStatusAgendado("cancelar");
        status = StatusAgendamento.CANCELADO;
    }

    public boolean ocupaHorario() {
        return status == StatusAgendamento.AGENDADO;
    }

    private void exigirStatusAgendado(String operacao) {
        if (status != StatusAgendamento.AGENDADO) {
            throw new IllegalStateException(
                    "Nao e possivel " + operacao + " um agendamento com status " + status + ".");
        }
    }
}
