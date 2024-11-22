package Exercicio13;

public class Peixe extends Animal {
    private String caracteristica;


    public Peixe(String nome, double comprimento, int numeroPatas, String cor, String ambiente, double velocidade, String caracteristica) {
        super(nome, comprimento, numeroPatas, cor, ambiente, velocidade);
        this.caracteristica = caracteristica;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return super.toString() + "Caracteristica: " + caracteristica;
    }
}
