import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public final class FolhaPagamento {
    public BigDecimal calcularTotal(List<? extends Funcionario> funcionarios) {
        validarLista(funcionarios);

        return funcionarios.stream()
                .map(Funcionario::calcularPagamento)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);
    }

    public List<ResumoPagamento> gerarResumos(List<? extends Funcionario> funcionarios) {
        validarLista(funcionarios);

        return funcionarios.stream()
                .map(funcionario -> new ResumoPagamento(
                        funcionario.getMatricula(),
                        funcionario.getNome(),
                        funcionario.calcularPagamento()))
                .toList();
    }

    private void validarLista(List<? extends Funcionario> funcionarios) {
        if (funcionarios == null) {
            throw new IllegalArgumentException("A lista de funcionarios deve ser informada.");
        }
        if (funcionarios.stream().anyMatch(funcionario -> funcionario == null)) {
            throw new IllegalArgumentException("A lista nao pode conter funcionario nulo.");
        }
    }
}
