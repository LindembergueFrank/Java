package com.repojava.javacoursebasico.intro.Enum;

public class TesteEnum {
    public static void main(String[] args) {

        /*Calculadora operacaoMultiplicar = Calculadora.MULTIPLICACAO;

        System.out.println(operacaoMultiplicar);
        System.out.println("Resultado de (4, 5): " + operacaoMultiplicar.executarOperacao(4, 5));

        Calculadora operacaoSomar = Calculadora.ADICAO;

        System.out.println("--------------------------");
        System.out.println(operacaoSomar);
        System.out.println("Resultado de (1, 19): "+ operacaoSomar.executarOperacao(1, 19));

        Calculadora operacaoSubtracao = Calculadora.SUBTRACAO;

        System.out.println("--------------------------");
        System.out.println(operacaoSubtracao);
        System.out.println("Resultado de (230, 9): " + operacaoSubtracao.executarOperacao(230, 9));

        Calculadora operacaoDivisao = Calculadora.DIVISAO;

        System.out.println("--------------------------");
        System.out.println(operacaoDivisao);
        System.out.println("Resultado de (2,3): " + operacaoDivisao.executarOperacao(2, 3));
        */

        double x = 2.0;
        double y = 3.0;

        for (Calculadora c : Calculadora.values()) {
            System.out.print(x + " ");
            System.out.print(c + " ");
            System.out.print(y + " = ");
            System.out.println(c.executarOperacao(x, y));
        }
    }
}
