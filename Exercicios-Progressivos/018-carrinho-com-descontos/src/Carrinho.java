import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public final class Carrinho {
    private static final BigDecimal LIMITE_DESCONTO_PREMIUM = new BigDecimal("200.00");
    private static final BigDecimal TAXA_DESCONTO_PREMIUM = new BigDecimal("0.10");

    private final CategoriaCliente categoria;
    private final List<ItemCarrinho> itens = new ArrayList<>();

    public Carrinho(CategoriaCliente categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("A categoria deve ser informada.");
        }
        this.categoria = categoria;
    }

    public void adicionar(Produto produto, int quantidade) {
        itens.add(new ItemCarrinho(produto, quantidade));
    }

    public List<ItemCarrinho> itens() {
        return List.copyOf(itens);
    }

    public ResumoCarrinho resumir() {
        BigDecimal subtotal = itens.stream()
                .map(ItemCarrinho::subtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add)
                .setScale(2, RoundingMode.HALF_UP);

        BigDecimal desconto = calcularDesconto(subtotal);
        return new ResumoCarrinho(subtotal, desconto, subtotal.subtract(desconto));
    }

    private BigDecimal calcularDesconto(BigDecimal subtotal) {
        if (categoria != CategoriaCliente.PREMIUM || subtotal.compareTo(LIMITE_DESCONTO_PREMIUM) < 0) {
            return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        }
        return subtotal.multiply(TAXA_DESCONTO_PREMIUM).setScale(2, RoundingMode.HALF_UP);
    }
}
