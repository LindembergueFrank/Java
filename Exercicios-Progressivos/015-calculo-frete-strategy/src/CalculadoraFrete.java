import java.math.BigDecimal;
import java.math.RoundingMode;

public final class CalculadoraFrete {
    private final PoliticaFrete politica;

    public CalculadoraFrete(PoliticaFrete politica) {
        if (politica == null) {
            throw new IllegalArgumentException("A politica de frete deve ser informada.");
        }
        this.politica = politica;
    }

    public BigDecimal calcular(PedidoEnvio pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido deve ser informado.");
        }
        BigDecimal valor = politica.calcular(pedido);
        if (valor == null || valor.signum() < 0) {
            throw new IllegalStateException("A politica retornou um valor de frete invalido.");
        }
        return valor.setScale(2, RoundingMode.HALF_UP);
    }
}
