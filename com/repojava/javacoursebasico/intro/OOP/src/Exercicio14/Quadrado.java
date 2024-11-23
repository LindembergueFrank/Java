package Exercicio14;

public class Quadrado extends Figura2D {
    private double base;
    private double altura;

    public Quadrado(String nome, String cor, double base, double altura) {
        super(nome, cor);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public String toString() {
        return getNome() + "\nCor: " + getCor() + ", Base: " + base + ", Altura: " + altura
                + "\nÁrea: " + String.format("%.2f",calcularArea());
    }
}
