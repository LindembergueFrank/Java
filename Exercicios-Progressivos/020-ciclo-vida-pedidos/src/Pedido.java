import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public final class Pedido {
    private final String codigo;
    private final List<ItemPedido> itens = new ArrayList<>();
    private StatusPedido status = StatusPedido.RASCUNHO;
    private Pagamento pagamento;

    public Pedido(String codigo) {
        if (codigo == null || codigo.isBlank()) throw new IllegalArgumentException("O codigo deve ser informado.");
        this.codigo = codigo.trim();
    }

    public String codigo() { return codigo; }
    public StatusPedido status() { return status; }
    public List<ItemPedido> itens() { return List.copyOf(itens); }
    public Optional<Pagamento> pagamento() { return Optional.ofNullable(pagamento); }

    public void adicionarItem(ItemPedido item) {
        exigirStatus(StatusPedido.RASCUNHO, "adicionar itens");
        if (item == null) throw new IllegalArgumentException("O item deve ser informado.");
        itens.add(item);
    }

    public BigDecimal total() {
        return itens.stream().map(ItemPedido::subtotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void confirmar() {
        exigirStatus(StatusPedido.RASCUNHO, "confirmar");
        if (itens.isEmpty()) throw new IllegalStateException("Nao e possivel confirmar um pedido sem itens.");
        status = StatusPedido.CONFIRMADO;
    }

    public void pagar(BigDecimal valor, Instant realizadoEm) {
        exigirStatus(StatusPedido.CONFIRMADO, "pagar");
        if (valor == null || valor.compareTo(total()) != 0) throw new IllegalArgumentException("O pagamento deve corresponder ao total do pedido.");
        pagamento = new Pagamento(valor, realizadoEm);
        status = StatusPedido.PAGO;
    }

    public void cancelar() {
        if (status != StatusPedido.RASCUNHO && status != StatusPedido.CONFIRMADO) {
            throw new IllegalStateException("Nao e possivel cancelar um pedido com status " + status + ".");
        }
        status = StatusPedido.CANCELADO;
    }

    private void exigirStatus(StatusPedido esperado, String operacao) {
        if (status != esperado) throw new IllegalStateException("Nao e possivel " + operacao + " um pedido com status " + status + ".");
    }
}
