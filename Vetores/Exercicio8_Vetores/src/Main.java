import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos elementos vai ter o vetor? ");
        int quantidade = sc.nextInt();
        int[] numerosLidos = new int[quantidade];
        int soma = 0;
        int quantidadePar = 0;
        boolean par = false;

        for (int i=0; i<numerosLidos.length; i++){
            System.out.print("Digite um numero: ");
            numerosLidos[i] = sc.nextInt();
            if (numerosLidos[i] % 2 == 0){
                soma+=numerosLidos[i];
                quantidadePar++;
                par = true;
            }
        }

        if(par){
            double media = soma/quantidadePar;
            System.out.printf("MEDIA DOS PARES = %.1f%n", media);
        }else {
            System.out.println("NENHUM NUMERO PAR");
        }

        sc.close();
    }
}