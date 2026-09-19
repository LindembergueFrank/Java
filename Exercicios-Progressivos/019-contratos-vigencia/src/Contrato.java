import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
import java.util.Optional;

public final class Contrato {
    private final DadosContrato dados;
    private LocalDate encerramentoAntecipado;

    public Contrato(DadosContrato dados) {
        this.dados = Objects.requireNonNull(dados, "Os dados do contrato devem ser informados.");
    }

    public DadosContrato dados() {
        return dados;
    }

    public Optional<LocalDate> encerramentoAntecipado() {
        return Optional.ofNullable(encerramentoAntecipado);
    }

    public void encerrarEm(LocalDate data) {
        Objects.requireNonNull(data, "A data de encerramento deve ser informada.");
        if (encerramentoAntecipado != null) {
            throw new IllegalStateException("O contrato ja foi encerrado antecipadamente.");
        }
        if (data.isBefore(dados.inicio())) {
            throw new IllegalArgumentException("O encerramento nao pode ocorrer antes do inicio.");
        }
        if (dados.fimPrevistoOpcional().filter(fim -> data.isAfter(fim)).isPresent()) {
            throw new IllegalArgumentException("O encerramento antecipado nao pode ocorrer apos o fim previsto.");
        }
        encerramentoAntecipado = data;
    }

    public SituacaoContrato situacaoEm(LocalDate referencia) {
        Objects.requireNonNull(referencia, "A data de referencia deve ser informada.");
        if (referencia.isBefore(dados.inicio())) {
            return SituacaoContrato.AGUARDANDO_INICIO;
        }
        if (dataEfetivaFim().filter(fim -> referencia.isAfter(fim)).isPresent()) {
            return SituacaoContrato.ENCERRADO;
        }
        return SituacaoContrato.ATIVO;
    }

    public Optional<LocalDate> dataEfetivaFim() {
        if (encerramentoAntecipado != null) {
            return Optional.of(encerramentoAntecipado);
        }
        return dados.fimPrevistoOpcional();
    }

    public Period tempoDecorridoAte(LocalDate referencia) {
        Objects.requireNonNull(referencia, "A data de referencia deve ser informada.");
        if (referencia.isBefore(dados.inicio())) {
            return Period.ZERO;
        }
        LocalDate limite = dataEfetivaFim()
                .filter(fim -> fim.isBefore(referencia))
                .orElse(referencia);
        return Period.between(dados.inicio(), limite);
    }
}
