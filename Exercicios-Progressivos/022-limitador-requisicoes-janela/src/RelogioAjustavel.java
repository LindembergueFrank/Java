import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;

public final class RelogioAjustavel extends Clock {
    private Instant instante;
    private final ZoneId zona;

    public RelogioAjustavel(Instant instante) {
        this(instante, ZoneOffset.UTC);
    }

    private RelogioAjustavel(Instant instante, ZoneId zona) {
        if (instante == null) throw new IllegalArgumentException("O instante deve ser informado.");
        this.instante = instante;
        this.zona = zona;
    }

    public void avancar(Duration duracao) {
        if (duracao == null || duracao.isNegative()) {
            throw new IllegalArgumentException("O avanco nao pode ser negativo.");
        }
        instante = instante.plus(duracao);
    }

    @Override
    public ZoneId getZone() {
        return zona;
    }

    @Override
    public Clock withZone(ZoneId zone) {
        if (zone == null) throw new IllegalArgumentException("A zona deve ser informada.");
        return new RelogioAjustavel(instante, zone);
    }

    @Override
    public Instant instant() {
        return instante;
    }
}
