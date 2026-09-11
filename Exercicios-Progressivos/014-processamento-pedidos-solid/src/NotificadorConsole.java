public final class NotificadorConsole implements Notificador {
    @Override
    public void enviarConfirmacao(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido deve ser informado.");
        }
        System.out.println("Pedido confirmado para " + pedido.getCliente() + ": " + pedido.getId());
    }
}
