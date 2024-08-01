import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        double[] numerosLidos = new double[quantidade];
        double soma = 0.0;


        for (int i=0; i<numerosLidos.length; i++){
            System.out.print("Digite um numero: ");
            numerosLidos[i] = sc.nextDouble();
            soma += numerosLidos[i];
        }

        System.out.println();
        System.out.print("VALORES =");

        for (int i=0; i<numerosLidos.length; i++){
            System.out.printf(" [ %.2f ]", numerosLidos[i]);
        }

        double media = soma/numerosLidos.length;
        System.out.println();
        System.out.printf("SOMA = %.2f%n", soma);
        System.out.printf("MEDIA = %.2f%n", media);

        sc.close();
    }
}