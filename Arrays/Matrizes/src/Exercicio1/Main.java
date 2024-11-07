package Exercicio1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[4][4];

        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                Random random = new Random();

                matriz[i][j] = random.nextInt(100);
            }
        }

        int maiorNumero = Integer.MIN_VALUE;
        int linha = 0;
        int coluna = 0;
        System.out.println("Matriz gerada: ");
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");

                if(matriz[i][j] > maiorNumero){
                    maiorNumero = matriz[i][j];
                    linha = i;
                    coluna = j;
                }
            }
            System.out.println();
        }

        System.out.println("\nMaior número: " + maiorNumero);
        System.out.println("Linha: " + linha);
        System.out.println("Coluna: " + coluna);
    }
}
