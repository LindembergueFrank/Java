import java.math.BigDecimal;

public record ItemCarrinho(Produto produto, int quantidade) {
    public ItemCarrinho {
        if (produto == null) {
            throw new IllegalArgumentException("O produto deve ser informado.");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }
    }

    public BigDecimal subtotal() {
        return produto.preco().multiply(BigDecimal.valueOf(quantidade));
    }
}
