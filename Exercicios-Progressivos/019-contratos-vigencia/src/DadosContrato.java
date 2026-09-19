import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public record DadosContrato(
        String codigo,
        LocalDate inicio,
        LocalDate fimPrevisto,
        BigDecimal valorMensal) {

    public DadosContrato {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O codigo deve ser informado.");
        }
        if (inicio == null) {
            throw new IllegalArgumentException("A data inicial deve ser informada.");
        }
        if (fimPrevisto != null && fimPrevisto.isBefore(inicio)) {
            throw new IllegalArgumentException("A data final nao pode ser anterior a inicial.");
        }
        if (valorMensal == null || valorMensal.signum() <= 0) {
            throw new IllegalArgumentException("O valor mensal deve ser positivo.");
        }
        codigo = codigo.trim();
    }

    public Optional<LocalDate> fimPrevistoOpcional() {
        return Optional.ofNullable(fimPrevisto);
    }
}
