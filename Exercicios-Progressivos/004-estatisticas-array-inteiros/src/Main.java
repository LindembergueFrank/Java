import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Quantos valores deseja analisar (1 a 100)? ");
            int quantidade = scanner.nextInt();

            if (quantidade < 1 || quantidade > 100) {
                System.out.println("Quantidade invalida. Informe um valor entre 1 e 100.");
                return;
            }

            int[] valores = new int[quantidade];
            long soma = 0L;
            int maior = 0;
            int menor = 0;

            for (int i = 0; i < valores.length; i++) {
                System.out.printf("Valor %d: ", i + 1);
                valores[i] = scanner.nextInt();
                soma += valores[i];

                if (i == 0) {
                    maior = valores[i];
                    menor = valores[i];
                } else {
                    if (valores[i] > maior) {
                        maior = valores[i];
                    }
                    if (valores[i] < menor) {
                        menor = valores[i];
                    }
                }
            }

            double media = (double) soma / valores.length;
            int acimaDaMedia = 0;

            for (int valor : valores) {
                if (valor > media) {
                    acimaDaMedia++;
                }
            }

            System.out.println();
            System.out.printf("Soma: %d%n", soma);
            System.out.printf("Media: %.2f%n", media);
            System.out.printf("Maior: %d%n", maior);
            System.out.printf("Menor: %d%n", menor);
            System.out.printf("Acima da media: %d%n", acimaDaMedia);

            System.out.print("Ordem inversa: ");
            for (int i = valores.length - 1; i >= 0; i--) {
                System.out.print(valores[i]);
                if (i > 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
