public class Evento {
    private final String descricao;
    private final String responsavel;

    public Evento(String descricao, String responsavel) {
        if (descricao == null || descricao.isBlank()) {
            throw new IllegalArgumentException("A descricao deve ser informada.");
        }
        if (responsavel == null || responsavel.isBlank()) {
            throw new IllegalArgumentException("O responsavel deve ser informado.");
        }

        this.descricao = descricao.trim();
        this.responsavel = responsavel.trim();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getResponsavel() {
        return responsavel;
    }

    @Override
    public String toString() {
        return descricao + " (" + responsavel + ")";
    }
}
