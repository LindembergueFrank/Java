package entities;

public class PessoaJuridica extends Contribuinte {
    private int numeroFuncionarios;

    public PessoaJuridica() {
        super();
    }

    public PessoaJuridica(String nome, double rendaAnual, int numeroFuncionarios) {
        super(nome, rendaAnual);
        this.numeroFuncionarios = numeroFuncionarios;
    }

    public int getNumeroFuncionarios() {
        return numeroFuncionarios;
    }

    public void setNumeroFuncionarios(int numeroFuncionarios) {
        this.numeroFuncionarios = numeroFuncionarios;
    }

    @Override
    public double calculaImposto() {
        if (numeroFuncionarios > 10) {
            double taxa = 0.14;
            return getRendaAnual() * taxa;
        }
        else {
            double taxa = 0.16;
            return getRendaAnual() * taxa;
        }
    }

    public String toString() {
        return getNome() +
                ": $" +
                String.format("%.2f", calculaImposto());
    }
}
