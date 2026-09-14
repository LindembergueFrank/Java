import java.math.BigDecimal;

public final class FuncionarioHorista extends Funcionario {
    private final BigDecimal valorHora;
    private final int horasTrabalhadas;

    public FuncionarioHorista(
            String matricula,
            String nome,
            BigDecimal valorHora,
            int horasTrabalhadas) {
        super(matricula, nome);
        if (valorHora == null || valorHora.signum() <= 0) {
            throw new IllegalArgumentException("O valor da hora deve ser positivo.");
        }
        if (horasTrabalhadas < 0 || horasTrabalhadas > 220) {
            throw new IllegalArgumentException("As horas trabalhadas devem estar entre 0 e 220.");
        }
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public BigDecimal calcularPagamento() {
        return monetario(valorHora.multiply(BigDecimal.valueOf(horasTrabalhadas)));
    }
}
