import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int [][] matriz = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matriz[i][j] == x) {
                    System.out.println("Position " + i + "," + j);
                    if(j > 0)
                        System.out.println("Left: " + matriz[i][j-1]);
                    if (i > 0)
                        System.out.println("Up: " + matriz[i-1][j]);
                    if (j < matriz[i].length - 1)
                        System.out.println("Right: " + matriz[i][j+1]);
                    if (i < matriz.length - 1)
                        System.out.println("Down: " + matriz[i+1][j]);
                }
            }
        }


    }
}