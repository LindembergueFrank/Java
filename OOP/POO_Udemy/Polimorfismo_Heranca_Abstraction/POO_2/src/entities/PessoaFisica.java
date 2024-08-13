package entities;

public class PessoaFisica extends Contribuinte{

    private double gastosSaude;

    public PessoaFisica() {
        super();
    }

    public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
        super(nome, rendaAnual);
        this.gastosSaude = gastosSaude;
    }

    public double getGastosSaude() {
        return gastosSaude;
    }

    public void setGastosSaude(double gastosSaude) {
        this.gastosSaude = gastosSaude;
    }

    @Override
    public double calculaImposto() {
        if (getRendaAnual() < 20000){
            double taxa = 0.15;
            return getRendaAnual() * taxa;
        }
        else if (getRendaAnual() >= 20000){
            double taxa = 0.25;
            if (getGastosSaude() > 0){
                double taxaSaude = 0.50;
                return ((getRendaAnual() * taxa) - (getGastosSaude() * taxaSaude));
            }
            return getRendaAnual() * taxa;
        }
        return 0;
    }

    public String toString() {
        return getNome() +
                ": $" +
                String.format("%.2f", calculaImposto());
    }
}
