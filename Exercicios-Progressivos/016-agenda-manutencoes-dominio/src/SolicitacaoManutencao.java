import java.time.Duration;
import java.time.LocalDateTime;

public record SolicitacaoManutencao(
        String codigo,
        TipoManutencao tipo,
        LocalDateTime inicio,
        Duration duracao) {

    public SolicitacaoManutencao {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("O codigo deve ser informado.");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("O tipo deve ser informado.");
        }
        if (inicio == null) {
            throw new IllegalArgumentException("O inicio deve ser informado.");
        }
        if (duracao == null || duracao.isZero() || duracao.isNegative()) {
            throw new IllegalArgumentException("A duracao deve ser positiva.");
        }

        codigo = codigo.trim();
    }

    public LocalDateTime fim() {
        return inicio.plus(duracao);
    }
}
