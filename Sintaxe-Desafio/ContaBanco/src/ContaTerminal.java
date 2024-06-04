import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        // Para o usuário conseguir informar o saldo usando "."
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        System.out.println("Bem vindo ao nosso Banco! Qual seu nome?");
        nomeCliente = sc.nextLine();

        System.out.println("Para localizarmos seu cadastro precisaremos de algumas informações. Por favor, digite o numério da agência!");
        agencia = sc.nextLine();

        System.out.println("Por favor, digite o número da conta.");
        numero = sc.nextInt();

        System.out.println("Por favor, digite o valor que deseja sacar.");
        saldo = sc.nextDouble();

        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, sua agência é " +
                           agencia + ", conta " + numero + " e seu saldo " + saldo + " já está disponível para saque" );
        
        sc.close();
    }
}
