import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Temperatura em Celsius: ");
            double celsius = scanner.nextDouble();

            double fahrenheit = (celsius * 9.0 / 5.0) + 32.0;
            double kelvin = celsius + 273.15;

            System.out.printf("Celsius: %.2f °C%n", celsius);
            System.out.printf("Fahrenheit: %.2f °F%n", fahrenheit);
            System.out.printf("Kelvin: %.2f K%n", kelvin);
        }
    }
}
