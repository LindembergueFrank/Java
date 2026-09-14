import java.math.BigDecimal;

public final class FuncionarioMensalista extends Funcionario {
    private final BigDecimal salarioBase;
    private final BigDecimal bonus;

    public FuncionarioMensalista(
            String matricula,
            String nome,
            BigDecimal salarioBase,
            BigDecimal bonus) {
        super(matricula, nome);
        if (salarioBase == null || salarioBase.signum() <= 0) {
            throw new IllegalArgumentException("O salario base deve ser positivo.");
        }
        if (bonus == null || bonus.signum() < 0) {
            throw new IllegalArgumentException("O bonus deve ser nao negativo.");
        }
        this.salarioBase = salarioBase;
        this.bonus = bonus;
    }

    @Override
    public BigDecimal calcularPagamento() {
        return monetario(salarioBase.add(bonus));
    }
}
