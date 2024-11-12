package Exercicio8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConversaoDeUnidadesDeArea area = new ConversaoDeUnidadesDeArea();

        boolean resposta = true;
        while (resposta != false) {
            System.out.println("\nCONVERSÃO DE UNIDADES DE AREA" +
                    "\n1- Metros² para Pés²" + "\n2- Pé² para Centímetros²" +
                    "\n3- Milha² para Acres" + "\n4- Acre para Pés²" + "\n0- Sair");
            int opcao = sc.nextInt();
            if (opcao == 1) {
                System.out.print("Passe o valor em metros²: ");
                int metros = sc.nextInt();
                area.metroParaPes(metros);
            } else if (opcao == 2) {
                System.out.print("Passe o valor em pés²: ");
                int pes = sc.nextInt();
                area.pesParaCentimetros(pes);
            } else if (opcao == 3) {
                System.out.print("Passe o valor em milha²: ");
                int milha = sc.nextInt();
                area.milhaParaAcres(milha);
            } else if (opcao == 4) {
                System.out.print("Passe o valor em acres²: ");
                int acres = sc.nextInt();
                area.acresParaPes(acres);
            } else  {
                resposta = false;
            }
        }
    }
}
