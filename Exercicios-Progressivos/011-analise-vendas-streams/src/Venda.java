import java.util.Objects;

public class Venda {
    private final String produto;
    private final String categoria;
    private final double valor;

    public Venda(String produto, String categoria, double valor) {
        if (produto == null || produto.isBlank()) {
            throw new IllegalArgumentException("O produto deve ser informado.");
        }
        if (categoria == null || categoria.isBlank()) {
            throw new IllegalArgumentException("A categoria deve ser informada.");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("O valor nao pode ser negativo.");
        }

        this.produto = produto.trim();
        this.categoria = categoria.trim();
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (!(outro instanceof Venda)) {
            return false;
        }
        Venda venda = (Venda) outro;
        return Double.compare(valor, venda.valor) == 0
                && produto.equals(venda.produto)
                && categoria.equals(venda.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, categoria, valor);
    }

    @Override
    public String toString() {
        return produto + " | " + categoria + " | R$ " + String.format("%.2f", valor);
    }
}
