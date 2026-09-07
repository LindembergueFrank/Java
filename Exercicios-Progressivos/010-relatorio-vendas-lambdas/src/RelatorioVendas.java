import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class RelatorioVendas {
    private final List<RegistroVenda> vendas;

    public RelatorioVendas(List<RegistroVenda> vendas) {
        if (vendas == null) {
            throw new IllegalArgumentException("A lista de vendas nao pode ser nula.");
        }
        for (RegistroVenda venda : vendas) {
            if (venda == null) {
                throw new IllegalArgumentException("A lista de vendas nao pode conter itens nulos.");
            }
        }
        this.vendas = List.copyOf(vendas);
    }

    public List<RegistroVenda> filtrar(Predicate<RegistroVenda> criterio) {
        if (criterio == null) {
            throw new IllegalArgumentException("O criterio deve ser informado.");
        }

        List<RegistroVenda> resultado = new ArrayList<>();
        for (RegistroVenda venda : vendas) {
            if (criterio.test(venda)) {
                resultado.add(venda);
            }
        }
        return List.copyOf(resultado);
    }

    public List<RegistroVenda> ordenar(Comparator<RegistroVenda> comparador) {
        if (comparador == null) {
            throw new IllegalArgumentException("O comparador deve ser informado.");
        }

        List<RegistroVenda> resultado = new ArrayList<>(vendas);
        resultado.sort(comparador);
        return List.copyOf(resultado);
    }

    public List<RegistroVenda> listar() {
        return vendas;
    }
}
