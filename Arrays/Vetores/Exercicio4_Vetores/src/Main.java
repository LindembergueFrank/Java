import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantidade = sc.nextInt();
        int[] numerosLidos = new int[quantidade];

        for (int i = 0; i < numerosLidos.length; i++) {
            System.out.print("Digite um numero: ");
            numerosLidos[i] = sc.nextInt();
        }

        System.out.println();
        System.out.println("NUMEROS PARES:");

        int soma = 0;
        for (int i = 0; i < numerosLidos.length; i++) {
            if (numerosLidos[i] % 2 == 0) {
                soma++;
                System.out.print(numerosLidos[i] + " ");
            }
        }

        System.out.println();
        System.out.println("QUANTIDADE DE PARES = " + soma);

        sc.close();
    }
}