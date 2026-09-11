import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        RepositorioPedidosMemoria repositorio = new RepositorioPedidosMemoria();
        Notificador notificador = new NotificadorConsole();
        ProcessadorPedido processador = new ProcessadorPedido(repositorio, notificador);

        Pedido pedido = new Pedido("PED-001", "Ana", new BigDecimal("349.90"));
        processador.processar(pedido);

        System.out.println("Pedidos persistidos: " + repositorio.listar().size());
    }
}
