public class Tarefa {
    private final String titulo;
    private boolean concluida;

    public Tarefa(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O titulo da tarefa deve ser informado.");
        }
        this.titulo = titulo.trim();
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void concluir() {
        concluida = true;
    }
}
