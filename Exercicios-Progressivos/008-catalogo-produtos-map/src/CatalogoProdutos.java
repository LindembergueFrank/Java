import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CatalogoProdutos {
    private final Map<String, Produto> produtosPorCodigo = new LinkedHashMap<>();

    public boolean adicionar(Produto produto) {
        if (produto == null) {
            throw new IllegalArgumentException("O produto deve ser informado.");
        }

        String chave = normalizarCodigo(produto.getCodigo());
        if (produtosPorCodigo.containsKey(chave)) {
            return false;
        }

        produtosPorCodigo.put(chave, produto);
        return true;
    }

    public Produto buscarPorCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return null;
        }
        return produtosPorCodigo.get(normalizarCodigo(codigo));
    }

    public boolean removerPorCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return false;
        }
        return produtosPorCodigo.remove(normalizarCodigo(codigo)) != null;
    }

    public List<Produto> listarTodos() {
        return List.copyOf(produtosPorCodigo.values());
    }

    public int quantidade() {
        return produtosPorCodigo.size();
    }

    private String normalizarCodigo(String codigo) {
        return codigo.trim().toUpperCase();
    }
}
