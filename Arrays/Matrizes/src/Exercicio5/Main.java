package Exercicio5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][][] agendaPessoal = new String[12][31][8];

        boolean sair = true;
        while (sair) {
            System.out.println("\n1 - Adicionar compromisso");
            System.out.println("2 - Visualizar compromisso");
            System.out.println("0 - Sair");

            int option = sc.nextInt();

            if (option == 1) {
                boolean mesValido = false;
                int mes = 0;

                while (!mesValido) {
                    System.out.print("Digite o mês (Apenas números): ");
                    mes = sc.nextInt();

                    if (mes > 0 && mes <= 12) {
                        mesValido = true;
                    } else {
                        System.out.println("Mẽs inválido, digite novamente");
                    }
                }

                boolean diaValido = false;
                int dia = 0;

                while (!diaValido) {
                    System.out.print("Digite o dia (Apenas números): ");
                    dia = sc.nextInt();

                    if (dia > 0 && dia <= 31) {
                        diaValido = true;
                    } else {
                        System.out.println("Dia inválido, digite novamente");
                    }
                }

                boolean horaValida = false;
                int hora = 0;

                while (!horaValida) {
                    System.out.print("Digite a hora: ");
                    hora = sc.nextInt();

                    if (hora >= 0 && hora <= 8) {
                        horaValida = true;
                    } else {
                        System.out.println("Hora inválida, digite novamente");
                    }
                }
                mes--;
                dia--;
                sc.nextLine();

                System.out.print("Digite o compromisso: ");
                agendaPessoal[mes][dia][hora] = sc.nextLine();

            } else if (option == 2) {
                boolean mesValido = false;
                int mes = 0;

                while (!mesValido) {
                    System.out.print("Digite o mês (Apenas números): ");
                    mes = sc.nextInt();

                    if (mes > 0 && mes <= 12) {
                        mesValido = true;
                    } else {
                        System.out.println("Mẽs inválido, digite novamente");
                    }
                }

                boolean diaValido = false;
                int dia = 0;

                while (!diaValido) {
                    System.out.print("Digite o dia (Apenas números): ");
                    dia = sc.nextInt();

                    if (dia > 0 && dia <= 31) {
                        diaValido = true;
                    } else {
                        System.out.println("Dia inválido, digite novamente");
                    }
                }

                boolean horaValida = false;
                int hora = 0;

                while (!horaValida) {
                    System.out.print("Digite a hora: ");
                    hora = sc.nextInt();

                    if (hora >= 0 && hora <= 8) {
                        horaValida = true;
                    } else {
                        System.out.println("Hora inválida, digite novamente");
                    }
                }

                System.out.print("Compromisso marcado para esta data: " + agendaPessoal[mes][dia][hora]);
            } else if (option == 0) {
                sair = false;
            } else {
                System.out.println("Invalid option");
            }
        }

        sc.close();
    }
}
