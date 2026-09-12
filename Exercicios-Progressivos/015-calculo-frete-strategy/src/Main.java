import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        PedidoEnvio pedido = new PedidoEnvio("PED-015", new BigDecimal("3.50"));

        BigDecimal economico = new CalculadoraFrete(new FreteEconomico()).calcular(pedido);
        BigDecimal expresso = new CalculadoraFrete(new FreteExpresso()).calcular(pedido);

        System.out.println("Pedido: " + pedido.getCodigo());
        System.out.println("Frete economico: R$ " + economico);
        System.out.println("Frete expresso: R$ " + expresso);
    }
}
