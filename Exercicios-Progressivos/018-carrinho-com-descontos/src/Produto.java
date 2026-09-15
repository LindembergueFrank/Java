import java.math.BigDecimal;

public record Produto(String nome, BigDecimal preco) {
    public Produto {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome deve ser informado.");
        }
        if (preco == null || preco.signum() < 0) {
            throw new IllegalArgumentException("O preco nao pode ser negativo.");
        }
        nome = nome.trim();
    }
}
