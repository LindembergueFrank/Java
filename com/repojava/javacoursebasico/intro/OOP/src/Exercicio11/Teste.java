package Exercicio11;

public class Teste {
    public static void main(String[] args) {
        ContaBancaria conta = new ContaBancaria("Roberto", "1223", 500);

        System.out.println("----Conta Bancaria (SuperClasse)----");
        System.out.println("Dados do cliente");
        System.out.println("Nome: " + conta.getNomeCliente());
        System.out.println("Número da conta: " + conta.getNomeCliente());
        System.out.println("Saldo inicial: R$" + conta.getSaldo());

        conta.depositar(50);
        System.out.println("\nSaldo: " + conta.getSaldo());

        conta.sacar(370);
        System.out.println("Saldo após saque: " + conta.getSaldo());

        System.out.println("\n----Conta Bancaria Especial----");

        ContaEspecial contaEspecial = new ContaEspecial("Gilberto", "67614", 600, 1000);

        System.out.println("Dados do cliente");
        System.out.println("Nome: " + contaEspecial.getNomeCliente());
        System.out.println("Número da conta: " + contaEspecial.getNumeroConta());
        System.out.println("Saldo inicial: R$" + contaEspecial.getSaldo());
        System.out.println("Limite inicial: " + contaEspecial.getLimite());

        contaEspecial.depositar(200);
        System.out.println("\nSaldo: " + contaEspecial.getSaldo());
        System.out.println("Limite da conta: " + contaEspecial.getLimite());

        contaEspecial.sacar(200);
        System.out.println("Saldo após 1º saque: " + contaEspecial.getSaldo());
        contaEspecial.sacar(1000);
        System.out.println("Saldo após 2º saque: " + contaEspecial.getSaldo());
        contaEspecial.sacar(50);
        System.out.println("Saldo após 3º saque: " + contaEspecial.getSaldo());

        System.out.println("\n----Conta Bancaria Poupança----");

        ContaPoupanca contaPoupanca = new ContaPoupanca("Marcelo", "782721", 500, 20);

        System.out.println("Dados do cliente");
        System.out.println("Nome: " + contaPoupanca.getNomeCliente());
        System.out.println("Número da conta: " + contaPoupanca.getNumeroConta());
        System.out.println("Saldo inicial: R$" + contaPoupanca.getSaldo());
        System.out.println("Taxa de rendimento: " + contaPoupanca.getTaxaRendimento() + "%");

        contaPoupanca.depositar(50);
        System.out.println("\nSaldo: " + contaPoupanca.getSaldo());
        contaPoupanca.sacar(150);
        System.out.println("Saldo após o saque: " + contaPoupanca.getSaldo());
        contaPoupanca.calcularNovoSaldo();
        System.out.println("Saldo após calcular com rendimento: " + contaPoupanca.getSaldo());
    }
}
