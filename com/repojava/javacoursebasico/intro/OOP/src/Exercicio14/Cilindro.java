package Exercicio14;

import java.util.concurrent.RecursiveTask;

public class Cilindro extends Figura3D{
    private double altura;
    private double raio;

    public Cilindro(String nome, String cor, double altura, double raio) {
        super(nome, cor);
        this.altura = altura;
        this.raio = raio;
    }

    @Override
    public double calcularVolume() {
        return ( Math.PI * ( Math.pow(raio, 2) * altura ) );
    }

    @Override
    public double calcularArea() {
        return ( ( (2*Math.PI) * raio ) * (raio + altura) );
    }

    @Override
    public String toString() {
        return getNome() + "\nCor = " + getCor() + ", Altura = "  + altura + ", Raio =" + raio
                + "\nÁrea: " + String.format("%.2f",calcularArea()) + ", Volume: " + String.format("%.2f",calcularVolume());
    }
}
