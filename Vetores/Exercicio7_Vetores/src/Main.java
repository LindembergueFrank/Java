import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int quantidade = sc.nextInt();
        double[] numerosLidos = new double[quantidade];
        double soma = 0.0;

        for (int i = 0; i < numerosLidos.length; i++) {
            System.out.print("Digite um numero: ");
            numerosLidos[i] = sc.nextDouble();
            soma += numerosLidos[i];
        }

        double media = soma / numerosLidos.length;

        System.out.println();
        System.out.printf("MEDIA DO VETOR = %.3f%n", media);
        System.out.println("ELEMENTOS ABAIXO DA MEDIA:");
        for (int i = 0; i < numerosLidos.length; i++) {
            if (numerosLidos[i] < media) {
                System.out.printf("%.1f%n", numerosLidos[i]);
            }
        }

        sc.close();
    }
}