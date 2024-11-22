package Exercicio12;

public class Main {
    public static void main(String[] args) {
        PessoaJuridica pJ = new PessoaJuridica("Alberto", 1800);

        System.out.println("----Pessoa Juridica----");

        System.out.println("\n" + pJ.getNome());
        System.out.println("Renda bruta: " + pJ.getRenda());
        System.out.println("Imposto a pagar: " + pJ.calcularImposto());

        System.out.println("----Pessoa Física----");

        PessoaFisica pF = new PessoaFisica("Iracema", 2500);

        System.out.println("\n" + pF.getNome());
        System.out.println("Renda bruta: " + pF.getRendaBruta());
        System.out.println("Imposto a pagar: " + pF.calcularImposto());

        pF.setRendaBruta(5000);
        System.out.println("Renda bruta: " + pF.getRendaBruta());
        System.out.println("Imposto a pagar: " + pF.calcularImposto());

        pF.setRendaBruta(1500);
        System.out.println("Renda bruta: " + pF.getRendaBruta());
        System.out.println("Imposto a pagar: " + pF.calcularImposto());
    }
}
