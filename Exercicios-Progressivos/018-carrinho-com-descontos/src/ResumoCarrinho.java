import java.math.BigDecimal;

public record ResumoCarrinho(BigDecimal subtotal, BigDecimal desconto, BigDecimal total) {
    public ResumoCarrinho {
        if (subtotal == null || desconto == null || total == null) {
            throw new IllegalArgumentException("Os valores do resumo devem ser informados.");
        }
        if (subtotal.signum() < 0 || desconto.signum() < 0 || total.signum() < 0) {
            throw new IllegalArgumentException("Os valores do resumo nao podem ser negativos.");
        }
        if (desconto.compareTo(subtotal) > 0 || total.compareTo(subtotal.subtract(desconto)) != 0) {
            throw new IllegalArgumentException("Resumo financeiro inconsistente.");
        }
    }
}
