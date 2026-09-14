import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = List.of(
                new FuncionarioMensalista(
                        "F001",
                        "Ana",
                        new BigDecimal("3500.00"),
                        new BigDecimal("450.75")),
                new FuncionarioHorista(
                        "F002",
                        "Bruno",
                        new BigDecimal("42.50"),
                        120));

        FolhaPagamento folha = new FolhaPagamento();

        folha.gerarResumos(funcionarios).forEach(resumo ->
                System.out.println(
                        resumo.matricula()
                                + " - "
                                + resumo.nome()
                                + ": R$ "
                                + resumo.valor()));

        System.out.println("Total: R$ " + folha.calcularTotal(funcionarios));
    }
}
