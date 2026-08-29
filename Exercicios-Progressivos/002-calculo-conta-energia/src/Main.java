import java.util.Locale;
import java.util.Scanner;

public class Main {
    private static final double TAXA_FIXA = 12.00;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Consumo mensal em kWh: ");
            double consumo = scanner.nextDouble();

            if (consumo < 0) {
                System.out.println("Consumo inválido. Informe um valor maior ou igual a zero.");
                return;
            }

            double tarifa;
            String faixa;

            if (consumo <= 100) {
                tarifa = 0.65;
                faixa = "BASICA";
            } else if (consumo <= 200) {
                tarifa = 0.75;
                faixa = "INTERMEDIARIA";
            } else {
                tarifa = 0.90;
                faixa = "ALTA";
            }

            double total = consumo * tarifa + TAXA_FIXA;

            System.out.printf("Consumo: %.2f kWh%n", consumo);
            System.out.printf("Faixa: %s%n", faixa);
            System.out.printf("Tarifa: R$ %.2f/kWh%n", tarifa);
            System.out.printf("Total: R$ %.2f%n", total);
        }
    }
}
