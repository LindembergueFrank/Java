import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
        CatalogoProdutos catalogo = new CatalogoProdutos();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Quantos produtos deseja cadastrar? ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            if (quantidade <= 0) {
                System.out.println("A quantidade deve ser maior que zero.");
                return;
            }

            for (int i = 1; i <= quantidade; i++) {
                System.out.printf("Codigo do produto %d: ", i);
                String codigo = scanner.nextLine();
                System.out.printf("Nome do produto %d: ", i);
                String nome = scanner.nextLine();
                System.out.printf("Preco do produto %d: ", i);
                double preco = scanner.nextDouble();
                scanner.nextLine();

                try {
                    Produto produto = new Produto(codigo, nome, preco);
                    if (!catalogo.adicionar(produto)) {
                        System.out.println("Codigo duplicado; produto nao cadastrado.");
                    }
                } catch (IllegalArgumentException exception) {
                    System.out.println("Produto invalido: " + exception.getMessage());
                    return;
                }
            }

            System.out.print("Codigo para consulta: ");
            Produto encontrado = catalogo.buscarPorCodigo(scanner.nextLine());

            if (encontrado == null) {
                System.out.println("Produto nao encontrado.");
            } else {
                System.out.printf("Encontrado: %s - %s - R$ %.2f%n",
                        encontrado.getCodigo(), encontrado.getNome(), encontrado.getPreco());
            }

            System.out.println("\nCatalogo:");
            for (Produto produto : catalogo.listarTodos()) {
                System.out.printf("- %s | %s | R$ %.2f%n",
                        produto.getCodigo(), produto.getNome(), produto.getPreco());
            }
        }
    }
}
