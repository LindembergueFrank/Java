import java.math.BigDecimal;
import java.math.RoundingMode;

public final class FreteExpresso implements PoliticaFrete {
    private static final BigDecimal TARIFA_BASE = new BigDecimal("18.00");
    private static final BigDecimal VALOR_POR_KG = new BigDecimal("2.50");

    @Override
    public BigDecimal calcular(PedidoEnvio pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido deve ser informado.");
        }
        return TARIFA_BASE.add(pedido.getPesoKg().multiply(VALOR_POR_KG))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
