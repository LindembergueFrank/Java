import java.math.BigDecimal;

public class CalculadoraFreteTest {
    public static void main(String[] args) {
        testarFreteEconomico();
        testarFreteExpresso();
        testarNovaPoliticaSemAlterarCalculadora();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarFreteEconomico() {
        PedidoEnvio pedido = new PedidoEnvio("PED-001", new BigDecimal("3.50"));
        BigDecimal valor = new CalculadoraFrete(new FreteEconomico()).calcular(pedido);
        assertBigDecimalEquals(new BigDecimal("12.20"), valor);
    }

    private static void testarFreteExpresso() {
        PedidoEnvio pedido = new PedidoEnvio("PED-002", new BigDecimal("3.50"));
        BigDecimal valor = new CalculadoraFrete(new FreteExpresso()).calcular(pedido);
        assertBigDecimalEquals(new BigDecimal("26.75"), valor);
    }

    private static void testarNovaPoliticaSemAlterarCalculadora() {
        PoliticaFrete retiradaLocal = pedido -> BigDecimal.ZERO;
        BigDecimal valor = new CalculadoraFrete(retiradaLocal)
                .calcular(new PedidoEnvio("PED-003", new BigDecimal("1.00")));
        assertBigDecimalEquals(new BigDecimal("0.00"), valor);
    }

    private static void testarValidacoes() {
        assertThrows(IllegalArgumentException.class, () -> new PedidoEnvio(" ", new BigDecimal("1.00")));
        assertThrows(IllegalArgumentException.class, () -> new PedidoEnvio("PED", BigDecimal.ZERO));
        assertThrows(IllegalArgumentException.class, () -> new CalculadoraFrete(null));
        assertThrows(IllegalArgumentException.class, () -> new CalculadoraFrete(new FreteEconomico()).calcular(null));
        assertThrows(IllegalStateException.class, () -> new CalculadoraFrete(pedido -> null)
                .calcular(new PedidoEnvio("PED", BigDecimal.ONE)));
        assertThrows(IllegalStateException.class, () -> new CalculadoraFrete(pedido -> new BigDecimal("-1.00"))
                .calcular(new PedidoEnvio("PED", BigDecimal.ONE)));
    }

    private static void assertBigDecimalEquals(BigDecimal esperado, BigDecimal atual) {
        if (esperado.compareTo(atual) != 0) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertThrows(Class<? extends Throwable> tipo, Executavel executavel) {
        try {
            executavel.executar();
        } catch (Throwable erro) {
            if (tipo.isInstance(erro)) {
                return;
            }
            throw new AssertionError("Excecao inesperada: " + erro.getClass().getName(), erro);
        }
        throw new AssertionError("Era esperada a excecao " + tipo.getName());
    }

    @FunctionalInterface
    private interface Executavel { void executar(); }
}
