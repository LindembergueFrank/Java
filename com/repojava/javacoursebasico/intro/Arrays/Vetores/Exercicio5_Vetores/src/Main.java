import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int quantidade = sc.nextInt();
        double[] numerosLidos = new double[quantidade];

        int posicaoMaiorValor = 0;
        double maiorValor = 0.0;

        for (int i = 0; i < numerosLidos.length; i++) {
            System.out.print("Digite um numero: ");
            numerosLidos[i] = sc.nextDouble();
        }

        for (int i = 0; i < numerosLidos.length; i++) {
            if (numerosLidos[i] > maiorValor && numerosLidos[i] > posicaoMaiorValor) {
                maiorValor = numerosLidos[i];
                posicaoMaiorValor = i;
            }
        }

        System.out.println();
        System.out.println("MAIOR VALOR = " + maiorValor);
        System.out.print("POSICAO DO MAIOR VALOR = " + posicaoMaiorValor);

        sc.close();
    }
}