public class Main {
    public static void main(String[] args) {
        Cliente bergue;
        bergue = new Cliente();
        bergue.setNome("Bergue");

        Conta cc = new ContaCorrente(bergue);
        Conta poupanca = new ContaPoupanca(bergue);

        cc.depositar(45);
        cc.transferir(30, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

    }
}
