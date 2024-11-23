package Exercicio14;

public class Circulo extends Figura2D{
    private double raio;

    public Circulo(String nome, String cor, double raio) {
        super(nome, cor);
        this.raio = raio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public String toString() {
        return getNome() + "\nCor: " + getCor() + ", Raio: " + raio
                + "\nÁrea: " + String.format("%.2f",calcularArea());
    }
}
