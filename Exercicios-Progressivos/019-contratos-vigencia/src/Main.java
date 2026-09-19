import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Contrato contrato = new Contrato(new DadosContrato(
                "CTR-019",
                LocalDate.of(2026, 1, 10),
                LocalDate.of(2026, 12, 31),
                new BigDecimal("1250.90")));

        LocalDate referencia = LocalDate.of(2026, 9, 19);
        System.out.println("Contrato: " + contrato.dados().codigo());
        System.out.println("Valor mensal: R$ " + contrato.dados().valorMensal());
        System.out.println("Situacao em " + referencia + ": " + contrato.situacaoEm(referencia));
        System.out.println("Tempo decorrido: " + contrato.tempoDecorridoAte(referencia));
    }
}
