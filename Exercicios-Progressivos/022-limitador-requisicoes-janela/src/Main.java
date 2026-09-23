import java.time.Duration;
import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        RelogioAjustavel relogio = new RelogioAjustavel(Instant.parse("2026-01-01T10:00:00Z"));
        LimiteRequisicoes limite = new LimiteRequisicoes(2, Duration.ofSeconds(10), relogio);

        System.out.println("1a requisicao: " + limite.tentar("cliente-1"));
        System.out.println("2a requisicao: " + limite.tentar("cliente-1"));
        System.out.println("3a requisicao: " + limite.tentar("cliente-1"));

        relogio.avancar(Duration.ofSeconds(10));
        System.out.println("Apos a janela: " + limite.tentar("cliente-1"));
    }
}
