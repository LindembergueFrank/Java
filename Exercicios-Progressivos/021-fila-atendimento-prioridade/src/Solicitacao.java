public record Solicitacao(String id, String descricao, Prioridade prioridade) {
    public Solicitacao {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("O id deve ser informado.");
        if (descricao == null || descricao.isBlank()) throw new IllegalArgumentException("A descricao deve ser informada.");
        if (prioridade == null) throw new IllegalArgumentException("A prioridade deve ser informada.");
        id = id.trim();
        descricao = descricao.trim();
    }
}
