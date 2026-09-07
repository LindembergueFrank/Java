import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<RegistroVenda> vendas = List.of(
                new RegistroVenda("Teclado", "Ana", 180.00),
                new RegistroVenda("Monitor", "Bruno", 1250.00),
                new RegistroVenda("Mouse", "Ana", 95.00),
                new RegistroVenda("Notebook", "Carla", 4200.00));

        RelatorioVendas relatorio = new RelatorioVendas(vendas);

        System.out.println("Vendas acima de R$ 500,00:");
        relatorio.filtrar(venda -> venda.getValor() > 500.00)
                .forEach(System.out::println);

        System.out.println("\nVendas ordenadas por valor decrescente:");
        relatorio.ordenar(Comparator.comparingDouble(RegistroVenda::getValor).reversed())
                .forEach(System.out::println);
    }
}
