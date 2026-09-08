import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnaliseVendas {
    private final List<Venda> vendas;

    public AnaliseVendas(List<Venda> vendas) {
        if (vendas == null) {
            throw new IllegalArgumentException("A lista de vendas nao pode ser nula.");
        }
        if (vendas.stream().anyMatch(venda -> venda == null)) {
            throw new IllegalArgumentException("A lista nao pode conter vendas nulas.");
        }
        this.vendas = List.copyOf(vendas);
    }

    public List<String> produtosAcimaDe(double valorMinimo) {
        return vendas.stream()
                .filter(venda -> venda.getValor() > valorMinimo)
                .sorted(Comparator.comparingDouble(Venda::getValor).reversed())
                .map(Venda::getProduto)
                .toList();
    }

    public double totalVendido() {
        return vendas.stream()
                .mapToDouble(Venda::getValor)
                .sum();
    }

    public Map<String, Double> totalPorCategoria() {
        return vendas.stream()
                .collect(Collectors.groupingBy(
                        Venda::getCategoria,
                        LinkedHashMap::new,
                        Collectors.summingDouble(Venda::getValor)));
    }

    public List<Venda> listar() {
        return vendas;
    }
}
