public class FilaAtendimentoTest {
    public static void main(String[] args) {
        deveAtenderPorPrioridade();
        devePreservarOrdemDeChegadaNoEmpate();
        deveConsultarERemoverDoIndice();
        deveRejeitarIdDuplicado();
        deveTratarFilaVazia();
        deveValidarSolicitacao();
        deveControlarTamanho();
        System.out.println("Todos os testes passaram.");
    }

    private static void deveAtenderPorPrioridade() {
        FilaAtendimento fila = new FilaAtendimento();
        fila.adicionar(sol("N", Prioridade.NORMAL));
        fila.adicionar(sol("U", Prioridade.URGENTE));
        fila.adicionar(sol("A", Prioridade.ALTA));
        fila.adicionar(sol("B", Prioridade.BAIXA));

        assertEquals("U", fila.proxima().orElseThrow().id());
        assertEquals("A", fila.proxima().orElseThrow().id());
        assertEquals("N", fila.proxima().orElseThrow().id());
        assertEquals("B", fila.proxima().orElseThrow().id());
    }

    private static void devePreservarOrdemDeChegadaNoEmpate() {
        FilaAtendimento fila = new FilaAtendimento();
        fila.adicionar(sol("A-1", Prioridade.ALTA));
        fila.adicionar(sol("A-2", Prioridade.ALTA));
        fila.adicionar(sol("A-3", Prioridade.ALTA));

        assertEquals("A-1", fila.proxima().orElseThrow().id());
        assertEquals("A-2", fila.proxima().orElseThrow().id());
        assertEquals("A-3", fila.proxima().orElseThrow().id());
    }

    private static void deveConsultarERemoverDoIndice() {
        FilaAtendimento fila = new FilaAtendimento();
        fila.adicionar(sol("SOL-1", Prioridade.NORMAL));

        assertTrue(fila.buscarPorId("SOL-1").isPresent());
        fila.proxima();
        assertTrue(fila.buscarPorId("SOL-1").isEmpty());
    }

    private static void deveRejeitarIdDuplicado() {
        FilaAtendimento fila = new FilaAtendimento();
        fila.adicionar(sol("DUP", Prioridade.BAIXA));
        assertThrows(IllegalArgumentException.class, () -> fila.adicionar(sol("DUP", Prioridade.URGENTE)));
        assertEquals(1, fila.tamanho());
    }

    private static void deveTratarFilaVazia() {
        FilaAtendimento fila = new FilaAtendimento();
        assertTrue(fila.proxima().isEmpty());
        assertTrue(fila.estaVazia());
        assertTrue(fila.buscarPorId("inexistente").isEmpty());
        assertTrue(fila.buscarPorId(null).isEmpty());
    }

    private static void deveValidarSolicitacao() {
        assertThrows(IllegalArgumentException.class, () -> new Solicitacao(" ", "Teste", Prioridade.NORMAL));
        assertThrows(IllegalArgumentException.class, () -> new Solicitacao("1", " ", Prioridade.NORMAL));
        assertThrows(IllegalArgumentException.class, () -> new Solicitacao("1", "Teste", null));
        assertThrows(IllegalArgumentException.class, () -> new FilaAtendimento().adicionar(null));
    }

    private static void deveControlarTamanho() {
        FilaAtendimento fila = new FilaAtendimento();
        fila.adicionar(sol("1", Prioridade.NORMAL));
        fila.adicionar(sol("2", Prioridade.ALTA));
        assertEquals(2, fila.tamanho());
        fila.proxima();
        assertEquals(1, fila.tamanho());
    }

    private static Solicitacao sol(String id, Prioridade prioridade) {
        return new Solicitacao(id, "Solicitacao " + id, prioridade);
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (!esperado.equals(atual)) throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) throw new AssertionError("A condicao esperada era verdadeira.");
    }

    private static void assertThrows(Class<? extends Throwable> tipo, Executavel executavel) {
        try {
            executavel.executar();
        } catch (Throwable erro) {
            if (tipo.isInstance(erro)) return;
            throw new AssertionError("Excecao inesperada: " + erro.getClass().getName(), erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipo.getName());
    }

    @FunctionalInterface
    private interface Executavel {
        void executar();
    }
}
