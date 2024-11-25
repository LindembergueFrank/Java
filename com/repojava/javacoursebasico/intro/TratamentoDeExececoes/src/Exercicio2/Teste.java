package Exercicio2;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        boolean continuar = true;

        while (continuar) {
            System.out.println("1 - Consult contact \n2 - Add contact \n0 - Exit");
            int op = sc.nextInt();

            if (op == 1) {
                //code for consult contact
            } else if (op == 2) {
                //code for add contact
            }
            else {
                continuar = false;
            }
        }
    }
}
