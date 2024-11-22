package Exercicio12;

public class PessoaJuridica extends Contribuente{
    static final double IMPOSTO_RENDA_BRUTA= 0.10;
    private double renda;

    public PessoaJuridica(String nome, double renda) {
        super(nome);
        this.renda = renda;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public double calcularImposto() {
        return IMPOSTO_RENDA_BRUTA * renda;
    }
}
