package Exercicio11;

public class ContaPoupanca extends ContaBancaria{
    private double taxaRendimento;

    public ContaPoupanca(String nomeCliente, String numeroConta, double saldo, double taxaRendimento) {
        super(nomeCliente, numeroConta, saldo);
        this.taxaRendimento = taxaRendimento;
    }


    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setDiaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    public void calcularNovoSaldo() {
        double juros = (taxaRendimento/100) * getSaldo();

        super.setSaldo(super.getSaldo() + juros);
    }
}
