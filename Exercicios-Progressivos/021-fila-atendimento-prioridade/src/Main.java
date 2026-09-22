public class Main {
    public static void main(String[] args) {
        FilaAtendimento fila = new FilaAtendimento();
        fila.adicionar(new Solicitacao("SOL-1", "Atualizar cadastro", Prioridade.NORMAL));
        fila.adicionar(new Solicitacao("SOL-2", "Servico indisponivel", Prioridade.URGENTE));
        fila.adicionar(new Solicitacao("SOL-3", "Falha de impressao", Prioridade.ALTA));

        while (!fila.estaVazia()) {
            Solicitacao atual = fila.proxima().orElseThrow();
            System.out.println(atual.id() + " - " + atual.prioridade() + " - " + atual.descricao());
        }
    }
}
