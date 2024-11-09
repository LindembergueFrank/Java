package ForEach;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        int[][] array2 = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        System.out.println("For each para imprimir o array");
        for (int value : array) {
            System.out.print(value + " ");
        }

        for (int i = 0; i < array2.length; i++) {
            for (int j = 0; j < array2[i].length; j++) {
                array2[i][j] = random.nextInt(100);
            }
        }
        System.out.println();

        System.out.println("\nFor each para imprimir a matriz");
        for (int[] valueArray : array2) {
            for (int value: valueArray) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
