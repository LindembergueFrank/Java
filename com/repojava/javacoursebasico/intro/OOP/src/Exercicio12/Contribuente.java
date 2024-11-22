package Exercicio12;

public abstract class Contribuente {
    private String nome;

    public Contribuente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double calcularImposto();
}
