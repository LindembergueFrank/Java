import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos numeros voce vai digitar? ");
        int n = sc.nextInt();
        int[] quantidade = new int[n];

        for (int i=0; i<quantidade.length; i++) {
            System.out.print("Digite um numero: ");
            quantidade[i] = sc.nextInt();
        }

        System.out.println("NUMEROS NEGATIVOS:");
        for (int i=0; i<quantidade.length; i++) {
            if (quantidade[i] < 0){
                System.out.println(quantidade[i]);
            }
        }

        sc.close();
    }
}