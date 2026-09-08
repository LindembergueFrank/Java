import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnaliseVendas analise = new AnaliseVendas(List.of(
                new Venda("Teclado", "Perifericos", 180.00),
                new Venda("Monitor", "Monitores", 1250.00),
                new Venda("Mouse", "Perifericos", 95.00),
                new Venda("Notebook", "Computadores", 4200.00),
                new Venda("Headset", "Perifericos", 320.00)));

        System.out.println("Produtos acima de R$ 300,00: " + analise.produtosAcimaDe(300.00));
        System.out.printf("Total vendido: R$ %.2f%n", analise.totalVendido());
        System.out.println("Total por categoria: " + analise.totalPorCategoria());
    }
}
