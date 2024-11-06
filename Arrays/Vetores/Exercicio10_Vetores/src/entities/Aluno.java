package entities;

public class Aluno {
    private String nome;
    private double primeiraNota;
    private double segundaNota;

    public String getNome() {
        return nome;
    }

    public double getPrimeiraNota() {
        return primeiraNota;
    }

    public double getSegundaNota() {
        return segundaNota;
    }

    public Aluno(String nome, double primeiraNota, double segundaNota) {
        this.nome = nome;
        this.primeiraNota = primeiraNota;
        this.segundaNota = segundaNota;
    }

}
