import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos valores vai ter cada vetor? ");
        int quantidade = sc.nextInt();

        int[] vetorA = new int[quantidade];
        int[] vetorB = new int[quantidade];
        int[] vetorC = new int[quantidade];

        System.out.println("Digite o valor do vetor A: ");
        for (int i = 0; i < vetorA.length; i++) {
            vetorA[i] = sc.nextInt();
        }

        System.out.println("Digite o valor do vetor B: ");
        for (int j = 0; j < vetorB.length; j++) {
            vetorB[j] = sc.nextInt();
        }

        System.out.println("VETOR RESULTANTE: ");
        for (int k = 0; k < vetorC.length; k++) {
            vetorC[k] = vetorA[k] + vetorB[k];
            System.out.println(vetorC[k]);
        }

        sc.close();
    }
}