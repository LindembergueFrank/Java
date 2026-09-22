import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;

public final class FilaAtendimento {
    private record Entrada(Solicitacao solicitacao, long ordemChegada) {}

    private static final Comparator<Entrada> ORDEM_ATENDIMENTO =
            Comparator.<Entrada>comparingInt(entrada -> entrada.solicitacao().prioridade().peso())
                    .reversed()
                    .thenComparingLong(Entrada::ordemChegada);

    private final PriorityQueue<Entrada> fila = new PriorityQueue<>(ORDEM_ATENDIMENTO);
    private final Map<String, Solicitacao> porId = new HashMap<>();
    private long proximaOrdem;

    public void adicionar(Solicitacao solicitacao) {
        if (solicitacao == null) throw new IllegalArgumentException("A solicitacao deve ser informada.");
        if (porId.containsKey(solicitacao.id())) {
            throw new IllegalArgumentException("Ja existe solicitacao com o id " + solicitacao.id() + ".");
        }

        fila.add(new Entrada(solicitacao, proximaOrdem++));
        porId.put(solicitacao.id(), solicitacao);
    }

    public Optional<Solicitacao> proxima() {
        Entrada entrada = fila.poll();
        if (entrada == null) return Optional.empty();

        Solicitacao solicitacao = entrada.solicitacao();
        porId.remove(solicitacao.id());
        return Optional.of(solicitacao);
    }

    public Optional<Solicitacao> buscarPorId(String id) {
        if (id == null || id.isBlank()) return Optional.empty();
        return Optional.ofNullable(porId.get(id.trim()));
    }

    public int tamanho() {
        return fila.size();
    }

    public boolean estaVazia() {
        return fila.isEmpty();
    }
}
