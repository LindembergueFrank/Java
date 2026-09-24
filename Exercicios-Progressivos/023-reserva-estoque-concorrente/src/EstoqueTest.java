import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class EstoqueTest {
    public static void main(String[] args) throws Exception {
        deveCadastrarEConsultar();
        deveValidarEntradas();
        deveRejeitarSaldoInsuficiente();
        devePreservarInvarianteSobConcorrencia();
        System.out.println("Todos os testes passaram.");
    }

    private static void deveCadastrarEConsultar() {
        Estoque estoque = new Estoque();
        estoque.cadastrar("produto-a", 10);
        assertEquals(10, estoque.saldo("produto-a").orElseThrow());
        assertTrue(estoque.saldo("inexistente").isEmpty());
    }

    private static void deveValidarEntradas() {
        Estoque estoque = new Estoque();
        assertThrows(IllegalArgumentException.class, () -> estoque.cadastrar(" ", 1));
        assertThrows(IllegalArgumentException.class, () -> estoque.cadastrar("x", -1));
        estoque.cadastrar("x", 1);
        assertThrows(IllegalArgumentException.class, () -> estoque.cadastrar("x", 2));
        assertThrows(IllegalArgumentException.class, () -> estoque.reservar("x", 0));
    }

    private static void deveRejeitarSaldoInsuficiente() {
        Estoque estoque = new Estoque();
        estoque.cadastrar("produto", 2);
        assertFalse(estoque.reservar("produto", 3));
        assertFalse(estoque.reservar("ausente", 1));
        assertEquals(2, estoque.saldo("produto").orElseThrow());
    }

    private static void devePreservarInvarianteSobConcorrencia() throws Exception {
        Estoque estoque = new Estoque();
        estoque.cadastrar("produto", 100);

        ExecutorService executor = Executors.newFixedThreadPool(8);
        try {
            List<Future<Boolean>> resultados = new ArrayList<>();
            for (int i = 0; i < 200; i++) {
                resultados.add(executor.submit(() -> estoque.reservar("produto", 1)));
            }

            int reservasAceitas = 0;
            for (Future<Boolean> resultado : resultados) {
                if (resultado.get()) reservasAceitas++;
            }

            assertEquals(100, reservasAceitas);
            assertEquals(0, estoque.saldo("produto").orElseThrow());
        } finally {
            executor.shutdown();
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
    }

    private static void assertEquals(int esperado, int atual) {
        if (esperado != atual) throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
    }

    private static void assertTrue(boolean condicao) {
        if (!condicao) throw new AssertionError("A condicao esperada era verdadeira.");
    }

    private static void assertFalse(boolean condicao) {
        if (condicao) throw new AssertionError("A condicao esperada era falsa.");
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
        void executar() throws Exception;
    }
}
