package Exercicio14;

public class Triangulo extends Figura2D {
    private double base;
    private double altura;

    public Triangulo(String nome, String cor, double base, double altura) {
        super(nome, cor);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return ( (base * altura) / 2 );
    }

    @Override
    public String toString() {
        return getNome() + "\nCor: " + getCor() + ", Base: " + base + ", Altura: " + altura
                + "\nArea: " + String.format("%.2f",calcularArea());
    }
}
