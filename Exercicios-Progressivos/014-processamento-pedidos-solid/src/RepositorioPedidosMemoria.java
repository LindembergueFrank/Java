import java.util.ArrayList;
import java.util.List;

public final class RepositorioPedidosMemoria implements RepositorioPedidos {
    private final List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void salvar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido deve ser informado.");
        }
        pedidos.add(pedido);
    }

    public List<Pedido> listar() {
        return List.copyOf(pedidos);
    }
}
