public enum Prioridade {
    BAIXA(1), NORMAL(2), ALTA(3), URGENTE(4);

    private final int peso;

    Prioridade(int peso) {
        this.peso = peso;
    }

    public int peso() {
        return peso;
    }
}
