package application;

import entities.Pensionato;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How manu rooms will be rented? ");
        int quantidade = sc.nextInt();
        Pensionato[] estudante = new Pensionato[10];
        int room = 0;

        for (int i = 1; i <= quantidade; i++) {
            sc.nextLine();
            System.out.println("Rent #" + (i));
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Room: ");
            room = sc.nextInt();
            System.out.println();

            estudante[room] = new Pensionato(nome, email);
        }

        System.out.println();
        System.out.println("Busy rooms: ");
        for (int i = 0; i < estudante.length; i++) {
            if (estudante[i] != null) {
                System.out.println(i + ": " + estudante[i].toString());
            }
        }

        sc.close();
    }
}