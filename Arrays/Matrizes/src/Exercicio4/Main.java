package Exercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] agendaPessoal = new String[30][24];

        boolean sair = true;
        while (sair) {
            System.out.println("\n1 - Adicionar compromisso");
            System.out.println("2 - Visualizar compromisso");
            System.out.println("0 - Sair");

            int option = sc.nextInt();

            if (option == 1) {
                System.out.print("Dia do compromisso: ");
                int dia = sc.nextInt();
                System.out.print("Hora do compromisso: ");
                int hora = sc.nextInt();
                sc.nextLine();

                System.out.print("Digite o nome do compromisso: ");
                agendaPessoal[dia][hora] = sc.next();

            } else if (option == 2) {
                System.out.print("Dia do compromisso: ");
                int dia = sc.nextInt();
                System.out.print("Hora do compromisso: ");
                int hora = sc.nextInt();

                System.out.println("Compromisso agendado para o dia" + dia + " às " + hora + "H: "
                        + agendaPessoal[dia][hora]);
            } else if (option == 0) {
                sair = false;
            } else {
                System.out.println("Invalid option");
            }
        }

        sc.close();
    }
}
