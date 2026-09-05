public class Produto {
    private final String codigo;
    private final String nome;
    private final double preco;

    public Produto(String codigo, String nome, double preco) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O codigo deve ser informado.");
        }
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome deve ser informado.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preco nao pode ser negativo.");
        }

        this.codigo = codigo.trim();
        this.nome = nome.trim();
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
