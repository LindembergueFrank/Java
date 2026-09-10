import java.time.LocalDateTime;
import java.util.Objects;

public class Registro {
    private final LocalDateTime dataHora;
    private final String mensagem;

    public Registro(LocalDateTime dataHora, String mensagem) {
        if (dataHora == null) {
            throw new IllegalArgumentException("A data e hora devem ser informadas.");
        }
        if (mensagem == null || mensagem.isBlank()) {
            throw new IllegalArgumentException("A mensagem deve ser informada.");
        }
        if (mensagem.indexOf('\t') >= 0 || mensagem.indexOf('\n') >= 0 || mensagem.indexOf('\r') >= 0) {
            throw new IllegalArgumentException("A mensagem nao pode conter tabulacoes ou quebras de linha.");
        }
        this.dataHora = dataHora;
        this.mensagem = mensagem.trim();
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    @Override
    public boolean equals(Object outro) {
        if (this == outro) {
            return true;
        }
        if (!(outro instanceof Registro)) {
            return false;
        }
        Registro registro = (Registro) outro;
        return dataHora.equals(registro.dataHora) && mensagem.equals(registro.mensagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataHora, mensagem);
    }

    @Override
    public String toString() {
        return dataHora + " | " + mensagem;
    }
}
