package Exercicio14;

public class Cubo extends Figura3D{
    private double arestas;

    public Cubo(String nome, String cor, double arestas) {
        super(nome, cor);
        this.arestas = arestas;
    }

    @Override
    public double calcularArea() {
        return ( 6 * (Math.pow(arestas, 2)) );
    }

    @Override
    public double calcularVolume() {
        return Math.pow(arestas, 3);
    }

    @Override
    public String toString() {
        return getNome() + "\nCor: " + getCor() + ", Arestas: " + arestas +
                "\nÁrea: " +String.format("%.2f",calcularArea()) + ", Volume: " + String.format("%.2f",calcularVolume());
    }
}
