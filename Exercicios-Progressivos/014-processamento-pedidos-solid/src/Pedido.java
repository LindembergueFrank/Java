import java.math.BigDecimal;
import java.util.Objects;

public final class Pedido {
    private final String id;
    private final String cliente;
    private final BigDecimal valorTotal;

    public Pedido(String id, String cliente, BigDecimal valorTotal) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("O id do pedido deve ser informado.");
        }
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("O cliente deve ser informado.");
        }
        if (valorTotal == null || valorTotal.signum() <= 0) {
            throw new IllegalArgumentException("O valor total deve ser positivo.");
        }
        this.id = id.trim();
        this.cliente = cliente.trim();
        this.valorTotal = valorTotal;
    }

    public String getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (!(outro instanceof Pedido)) {
            return false;
        }
        Pedido pedido = (Pedido) outro;
        return id.equals(pedido.id)
                && cliente.equals(pedido.cliente)
                && valorTotal.equals(pedido.valorTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cliente, valorTotal);
    }

    @Override
    public String toString() {
        return id + " | " + cliente + " | R$ " + valorTotal;
    }
}
