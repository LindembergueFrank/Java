import java.math.BigDecimal;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido("PED-020");
        pedido.adicionarItem(new ItemPedido("Adaptador", 2, new BigDecimal("35.90")));
        pedido.adicionarItem(new ItemPedido("Cabo", 1, new BigDecimal("18.20")));
        pedido.confirmar();
        pedido.pagar(pedido.total(), Instant.parse("2026-09-20T12:00:00Z"));

        System.out.println("Pedido: " + pedido.codigo());
        System.out.println("Total: R$ " + pedido.total());
        System.out.println("Status: " + pedido.status());
        System.out.println("Pagamento registrado: " + pedido.pagamento().isPresent());
    }
}
