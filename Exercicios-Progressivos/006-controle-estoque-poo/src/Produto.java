public class Produto {
    private final String nome;
    private final double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidadeInicial) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto deve ser informado.");
        }
        if (preco <= 0) {
            throw new IllegalArgumentException("O preco deve ser maior que zero.");
        }
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("A quantidade inicial nao pode ser negativa.");
        }

        this.nome = nome.trim();
        this.preco = preco;
        this.quantidade = quantidadeInicial;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularValorTotal() {
        return preco * quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        validarQuantidadePositiva(quantidade);
        this.quantidade += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        validarQuantidadePositiva(quantidade);

        if (quantidade > this.quantidade) {
            return false;
        }

        this.quantidade -= quantidade;
        return true;
    }

    private void validarQuantidadePositiva(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
    }
}
