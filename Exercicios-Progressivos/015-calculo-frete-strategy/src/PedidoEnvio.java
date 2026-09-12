import java.math.BigDecimal;

public final class PedidoEnvio {
    private final String codigo;
    private final BigDecimal pesoKg;

    public PedidoEnvio(String codigo, BigDecimal pesoKg) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O codigo deve ser informado.");
        }
        if (pesoKg == null || pesoKg.signum() <= 0) {
            throw new IllegalArgumentException("O peso deve ser positivo.");
        }
        this.codigo = codigo.trim();
        this.pesoKg = pesoKg;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getPesoKg() {
        return pesoKg;
    }
}
