package com.repojava.javacoursebasico.intro.Enum;

public enum Calculadora {
    ADICAO("+") {
        @Override
        public double executarOperacao(double x, double y) {
            return x + y;
        }
    }, SUBTRACAO("-") {
        @Override
        public double executarOperacao(double x, double y) {
            return x - y;
        }
    }, DIVISAO("/") {
        @Override
        public double executarOperacao(double x, double y) {
            if (y == 0) {
                System.out.println("Não é possível divisão por zero!");
            } else if (x == 0 && y > 0) {
                return 0;
            }

            return x / y;
        }
    }, MULTIPLICACAO("*") {
        @Override
        public double executarOperacao(double x, double y) {
            return x * y;
        }
    };

    private String simbolo;

    private Calculadora(String simbolo) {
        this.simbolo = simbolo;
    }

    private String getSimbolo() {
        return simbolo;
    }

    public abstract double executarOperacao(double x, double y);

    @Override
    public String toString() {
        return simbolo;
    }
}
