import java.math.BigDecimal;

@FunctionalInterface
public interface PoliticaFrete {
    BigDecimal calcular(PedidoEnvio pedido);
}
