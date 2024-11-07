package Exercicio3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] matriz = new int[3][3];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.println("Insira o valor a ser inserido na linha " + i +
                        ", coluna " + j + " : ");
                matriz[i][j] = sc.nextInt();
            }
        }

        int qtdPares = 0;
        int qtdImpares = 0;
        System.out.println("Matriz gerada: ");
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");

                if (matriz[i][j] % 2 == 0){
                    qtdPares++;
                } else {
                    qtdImpares++;
                }
            }
            System.out.println();
        }

        System.out.println("\nQuantidade de pares: " + qtdPares);
        System.out.println("Quantidade de impares: " + qtdImpares);

        sc.close();
    }
}
