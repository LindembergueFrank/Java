public final class ProcessadorPedido {
    private final RepositorioPedidos repositorio;
    private final Notificador notificador;

    public ProcessadorPedido(RepositorioPedidos repositorio, Notificador notificador) {
        if (repositorio == null) {
            throw new IllegalArgumentException("O repositorio deve ser informado.");
        }
        if (notificador == null) {
            throw new IllegalArgumentException("O notificador deve ser informado.");
        }
        this.repositorio = repositorio;
        this.notificador = notificador;
    }

    public void processar(Pedido pedido) {
        if (pedido == null) {
            throw new IllegalArgumentException("O pedido deve ser informado.");
        }
        repositorio.salvar(pedido);
        notificador.enviarConfirmacao(pedido);
    }
}
