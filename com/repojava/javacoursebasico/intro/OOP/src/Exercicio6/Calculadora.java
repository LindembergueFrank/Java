package Exercicio6;

public class Calculadora {
    private double num1;
    private double num2;
    
    public Calculadora(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    
    public double soma() {
        return num1 + num2;
    }
    
    public double subtracao() {
        return num1 - num2;
    }
    
    public double multiplicacao() {
        return num1 * num2;
    }
    
    public double divisao() {
        if (num2 == 0) {
            System.out.print("Não é possível dividir por zero");
        } else {
            return num1 / num2;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "\nResultados" + "Soma: " + soma() + "\nSubtração: " + subtracao()
                + "\nMultiplicação: " + multiplicacao() + "\nDivisão: " + divisao();
    }
}
