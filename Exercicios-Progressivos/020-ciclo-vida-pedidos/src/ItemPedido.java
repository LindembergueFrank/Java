import java.math.BigDecimal;

public record ItemPedido(String descricao, int quantidade, BigDecimal precoUnitario) {
    public ItemPedido {
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("A descricao deve ser informada.");
        if (quantidade <= 0) throw new IllegalArgumentException("A quantidade deve ser positiva.");
        if (precoUnitario == null || precoUnitario.signum() <= 0) throw new IllegalArgumentException("O preco deve ser positivo.");
        descricao = descricao.trim();
    }

    public BigDecimal subtotal() {
        return precoUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}
