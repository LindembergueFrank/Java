import java.math.BigDecimal;
import java.time.Instant;

public record Pagamento(BigDecimal valor, Instant realizadoEm) {
    public Pagamento {
        if (valor == null || valor.signum() <= 0) throw new IllegalArgumentException("O valor deve ser positivo.");
        if (realizadoEm == null) throw new IllegalArgumentException("O instante do pagamento deve ser informado.");
    }
}
