import java.util.Objects;

public class RegistroVenda {
    private final String produto;
    private final String vendedor;
    private final double valor;

    public RegistroVenda(String produto, String vendedor, double valor) {
        if (produto == null || produto.isBlank()) {
            throw new IllegalArgumentException("O produto deve ser informado.");
        }
        if (vendedor == null || vendedor.isBlank()) {
            throw new IllegalArgumentException("O vendedor deve ser informado.");
        }
        if (valor < 0) {
            throw new IllegalArgumentException("O valor nao pode ser negativo.");
        }

        this.produto = produto.trim();
        this.vendedor = vendedor.trim();
        this.valor = valor;
    }

    public String getProduto() {
        return produto;
    }

    public String getVendedor() {
        return vendedor;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (!(outro instanceof RegistroVenda)) {
            return false;
        }
        RegistroVenda venda = (RegistroVenda) outro;
        return Double.compare(valor, venda.valor) == 0
                && produto.equals(venda.produto)
                && vendedor.equals(venda.vendedor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produto, vendedor, valor);
    }

    @Override
    public String toString() {
        return produto + " - " + vendedor + " - R$ " + String.format("%.2f", valor);
    }
}
