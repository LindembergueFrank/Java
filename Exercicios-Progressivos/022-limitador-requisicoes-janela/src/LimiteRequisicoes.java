import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public final class LimiteRequisicoes {
    private final int limite;
    private final Duration janela;
    private final Clock relogio;
    private final Map<String, Deque<Instant>> requisicoesPorCliente = new HashMap<>();

    public LimiteRequisicoes(int limite, Duration janela, Clock relogio) {
        if (limite <= 0) throw new IllegalArgumentException("O limite deve ser positivo.");
        if (janela == null || janela.isZero() || janela.isNegative()) {
            throw new IllegalArgumentException("A janela deve ser positiva.");
        }
        if (relogio == null) throw new IllegalArgumentException("O relogio deve ser informado.");
        this.limite = limite;
        this.janela = janela;
        this.relogio = relogio;
    }

    public boolean tentar(String cliente) {
        String chave = validarCliente(cliente);
        Instant agora = relogio.instant();
        Deque<Instant> historico = requisicoesPorCliente.computeIfAbsent(chave, ignorado -> new ArrayDeque<>());
        removerExpiradas(historico, agora);

        if (historico.size() >= limite) return false;
        historico.addLast(agora);
        return true;
    }

    public int requisicoesAtivas(String cliente) {
        String chave = validarCliente(cliente);
        Deque<Instant> historico = requisicoesPorCliente.get(chave);
        if (historico == null) return 0;

        removerExpiradas(historico, relogio.instant());
        if (historico.isEmpty()) requisicoesPorCliente.remove(chave);
        return historico.size();
    }

    private void removerExpiradas(Deque<Instant> historico, Instant agora) {
        Instant inicioJanela = agora.minus(janela);
        while (!historico.isEmpty() && !historico.peekFirst().isAfter(inicioJanela)) {
            historico.removeFirst();
        }
    }

    private String validarCliente(String cliente) {
        if (cliente == null || cliente.isBlank()) {
            throw new IllegalArgumentException("O cliente deve ser informado.");
        }
        return cliente.trim();
    }
}
