import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int quantidade = 0;
            long soma = 0L;
            int positivos = 0;
            int negativos = 0;
            int pares = 0;
            int impares = 0;
            int maior = 0;
            int menor = 0;

            while (true) {
                System.out.print("Informe um numero inteiro (0 para encerrar): ");
                int valor = scanner.nextInt();

                if (valor == 0) {
                    break;
                }

                soma += valor;
                quantidade++;

                if (quantidade == 1) {
                    maior = valor;
                    menor = valor;
                } else {
                    if (valor > maior) {
                        maior = valor;
                    }
                    if (valor < menor) {
                        menor = valor;
                    }
                }

                if (valor > 0) {
                    positivos++;
                } else {
                    negativos++;
                }

                if (valor % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }
            }

            if (quantidade == 0) {
                System.out.println("Nenhum valor foi informado para analise.");
                return;
            }

            double media = (double) soma / quantidade;

            System.out.println();
            System.out.printf("Quantidade: %d%n", quantidade);
            System.out.printf("Soma: %d%n", soma);
            System.out.printf("Media: %.2f%n", media);
            System.out.printf("Positivos: %d%n", positivos);
            System.out.printf("Negativos: %d%n", negativos);
            System.out.printf("Pares: %d%n", pares);
            System.out.printf("Impares: %d%n", impares);
            System.out.printf("Maior: %d%n", maior);
            System.out.printf("Menor: %d%n", menor);
        }
    }
}
