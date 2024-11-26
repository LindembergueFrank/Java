package Exercicio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean continuar = true;

        System.out.print("Max contacts in your agenda? ");
        int qtdContatos = sc.nextInt();
        Agenda agenda = new Agenda(qtdContatos);

        try{
            while (continuar) {
                System.out.println("\n1 - Add contact \n2 - Consult contact \n3 - Consult all contacts \n0 - Exit");
                int op = sc.nextInt();


                if (op == 1) {
                    //code for consult contact
                    System.out.print("Inser your first name: ");
                    String name = sc.next();
                    System.out.print("Insert your number phone: ");
                    long number = sc.nextLong();

                    agenda.addContact(name, number);

                } else if (op == 2) {
                    //code for add contact
                    System.out.print("Digite o nome do contato que deseja encontrar: ");
                    String nameContact = sc.next();

                    agenda.consultContact(nameContact);
                } else if (op == 3) {
                    agenda.consultAllContacts();
                }
                else {
                    continuar = false;
                }
            }
        }
        catch (ContatoNaoExisteException | AgendaCheiaException e) {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) {
            System.out.println("Tipo de dado incorreto, verifique novamente o que é solicitado!");
        }

    }
}
