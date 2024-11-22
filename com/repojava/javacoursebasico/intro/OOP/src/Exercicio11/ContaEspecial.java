package Exercicio11;

public class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String nomeCliente, String numeroConta, double saldo, double limite) {
        super(nomeCliente, numeroConta, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public void sacar(double valor) {
        if (super.getSaldo() >= valor) {
            super.setSaldo(super.getSaldo() - valor);
        } else if (limite >= valor && super.getSaldo() < valor) {
            limite -= valor;
            super.setSaldo(limite - valor);
            System.out.println("Saldo insuficiente, usaremos o limite para realizar o saque");
        } else {
            System.out.println("Saldo/limite insuficiente para realizar o saque");
        }
    }
}
