import java.math.BigDecimal;

public record ResumoPagamento(
        String matricula,
        String nome,
        BigDecimal valor) {

    public ResumoPagamento {
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("A matricula deve ser informada.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome deve ser informado.");
        }
        if (valor == null || valor.signum() < 0) {
            throw new IllegalArgumentException("O valor deve ser nao negativo.");
        }
    }
}
