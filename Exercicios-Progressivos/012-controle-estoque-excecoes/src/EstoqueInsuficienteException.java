public class EstoqueInsuficienteException extends Exception {
    private final String produto;
    private final int solicitado;
    private final int disponivel;

    public EstoqueInsuficienteException(String produto, int solicitado, int disponivel) {
        super("Estoque insuficiente para " + produto + ": solicitado=" + solicitado + ", disponivel=" + disponivel);
        this.produto = produto;
        this.solicitado = solicitado;
        this.disponivel = disponivel;
    }

    public String getProduto() {
        return produto;
    }

    public int getSolicitado() {
        return solicitado;
    }

    public int getDisponivel() {
        return disponivel;
    }
}
