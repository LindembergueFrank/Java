import java.util.Objects;

public class ItemEstoque {
    private final String nome;
    private int quantidade;

    public ItemEstoque(String nome, int quantidadeInicial) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do item deve ser informado.");
        }
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("A quantidade inicial nao pode ser negativa.");
        }
        this.nome = nome.trim();
        this.quantidade = quantidadeInicial;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void adicionar(int quantidade) {
        validarQuantidadePositiva(quantidade);
        this.quantidade += quantidade;
    }

    public void retirar(int quantidade) throws EstoqueInsuficienteException {
        validarQuantidadePositiva(quantidade);
        if (quantidade > this.quantidade) {
            throw new EstoqueInsuficienteException(nome, quantidade, this.quantidade);
        }
        this.quantidade -= quantidade;
    }

    private void validarQuantidadePositiva(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (!(outro instanceof ItemEstoque)) {
            return false;
        }
        ItemEstoque item = (ItemEstoque) outro;
        return quantidade == item.quantidade && nome.equals(item.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, quantidade);
    }

    @Override
    public String toString() {
        return nome + " | quantidade=" + quantidade;
    }
}
