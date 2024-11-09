package Exercicio6;

public class Main {
    public static void main(String[] args) {
        Calculadora teste = new Calculadora(8.5, 5);
        Calculadora teste2 = new Calculadora(2, 0);

        System.out.println("Subtração: " + teste.subtracao());
        System.out.println("Soma: " + teste.soma());
        System.out.println("Multiplicação: " + teste.multiplicacao());
        System.out.println("Divisão: " + teste.divisao());
        System.out.println("------------------------");

        System.out.println(teste2);

    }
}
