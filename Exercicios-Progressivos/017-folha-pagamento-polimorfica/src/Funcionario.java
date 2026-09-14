import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Funcionario {
    private final String matricula;
    private final String nome;

    protected Funcionario(String matricula, String nome) {
        if (matricula == null || matricula.isBlank()) {
            throw new IllegalArgumentException("A matricula deve ser informada.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome deve ser informado.");
        }
        this.matricula = matricula.trim();
        this.nome = nome.trim();
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public abstract BigDecimal calcularPagamento();

    protected BigDecimal monetario(BigDecimal valor) {
        if (valor == null || valor.signum() < 0) {
            throw new IllegalArgumentException("O valor monetario deve ser nao negativo.");
        }
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}
