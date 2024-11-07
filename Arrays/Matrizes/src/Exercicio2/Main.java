package Exercicio2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[10][10];

        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                Random random = new Random();

                matriz[i][j] = random.nextInt(50);
            }
        }

        System.out.println("Matriz gerada: ");
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

        int menorNumeroL5 = Integer.MAX_VALUE;
        int maiorNumeroL5 = Integer.MIN_VALUE;
        int linha5 = 5;
        for (int i = 0; i < matriz[linha5].length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[linha5][j] < menorNumeroL5) {
                    menorNumeroL5 = matriz[linha5][j];
                }
                if (matriz[linha5][j] > maiorNumeroL5) {
                    maiorNumeroL5 = matriz[linha5][j];
                }
            }
        }
        System.out.println("\nMaior numero que consta na linha 5: " + maiorNumeroL5);
        System.out.println("Menor numero que consta na linha 5: " + menorNumeroL5);

        int menorNumeroC7 = Integer.MAX_VALUE;
        int maiorNumeroC7 = Integer.MIN_VALUE;
        int coluna7 = 7;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[coluna7].length; j++) {
                if (matriz[i][coluna7] < menorNumeroC7) {
                    menorNumeroC7 = matriz[i][coluna7];
                }
                if (matriz[i][coluna7] > maiorNumeroC7) {
                    maiorNumeroC7 = matriz[i][coluna7];
                }
            }
        }

        System.out.println("\nMaior numero que consta na coluna 7: " + maiorNumeroC7);
        System.out.println("Menor numero que consta na coluna 7: " + menorNumeroC7);
    }
}
