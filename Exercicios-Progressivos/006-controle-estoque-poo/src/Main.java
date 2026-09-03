import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nome do produto: ");
            String nome = scanner.nextLine();

            System.out.print("Preco unitario: ");
            double preco = scanner.nextDouble();

            System.out.print("Quantidade inicial: ");
            int quantidadeInicial = scanner.nextInt();

            Produto produto;
            try {
                produto = new Produto(nome, preco, quantidadeInicial);
            } catch (IllegalArgumentException exception) {
                System.out.println("Dados invalidos: " + exception.getMessage());
                return;
            }

            System.out.print("Quantidade para entrada: ");
            int entrada = scanner.nextInt();

            try {
                produto.adicionarEstoque(entrada);
            } catch (IllegalArgumentException exception) {
                System.out.println("Entrada invalida: " + exception.getMessage());
                return;
            }

            System.out.print("Quantidade para saida: ");
            int saida = scanner.nextInt();

            boolean removido;
            try {
                removido = produto.removerEstoque(saida);
            } catch (IllegalArgumentException exception) {
                System.out.println("Saida invalida: " + exception.getMessage());
                return;
            }

            System.out.printf("%nProduto: %s%n", produto.getNome());
            System.out.printf("Preco: R$ %.2f%n", produto.getPreco());
            System.out.printf("Quantidade em estoque: %d%n", produto.getQuantidade());
            System.out.printf("Valor total em estoque: R$ %.2f%n", produto.calcularValorTotal());
            System.out.printf("Saida realizada: %s%n", removido ? "sim" : "nao");
        }
    }
}
