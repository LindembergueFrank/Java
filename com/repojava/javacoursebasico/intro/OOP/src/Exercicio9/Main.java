package Exercicio9;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o nome da agenda: ");
        String nomeAgenda = sc.nextLine();
        Agenda agenda = new Agenda(nomeAgenda);

        Contato[] contatos = new Contato[3];
        for (int i = 0; i < 3; i++) {
            Contato c = new Contato();

            System.out.println("Contato " + (i+1));

            System.out.print("Digite o nome do contato: ");
            String nomeContato = sc.nextLine();
            c.setName(nomeContato);

            System.out.print("Digite o telefone do contato: ");
            String telefoneContato = sc.nextLine();
            c.setTelefone(telefoneContato);

            System.out.print("Digite o email do contato: ");
            String emailContato = sc.nextLine();
            c.setEmail(emailContato);

            contatos[i] = c;
        }
        agenda.setContatos(contatos);

        System.out.println("-------");
        if (agenda != null) {
            System.out.println(agenda.imprimir());
        }

        sc.close();
    }
}
