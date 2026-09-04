import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private final List<Tarefa> tarefas = new ArrayList<>();

    public void adicionar(Tarefa tarefa) {
        if (tarefa == null) {
            throw new IllegalArgumentException("A tarefa deve ser informada.");
        }
        tarefas.add(tarefa);
    }

    public Tarefa buscarPorTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            return null;
        }

        for (Tarefa tarefa : tarefas) {
            if (tarefa.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return tarefa;
            }
        }
        return null;
    }

    public boolean concluir(String titulo) {
        Tarefa tarefa = buscarPorTitulo(titulo);
        if (tarefa == null) {
            return false;
        }
        tarefa.concluir();
        return true;
    }

    public List<Tarefa> listarTodas() {
        return List.copyOf(tarefas);
    }

    public List<Tarefa> listarPendentes() {
        List<Tarefa> pendentes = new ArrayList<>();
        for (Tarefa tarefa : tarefas) {
            if (!tarefa.isConcluida()) {
                pendentes.add(tarefa);
            }
        }
        return List.copyOf(pendentes);
    }

    public int quantidade() {
        return tarefas.size();
    }
}
