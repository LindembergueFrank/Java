import java.math.BigDecimal;

public class CarrinhoTest {
    public static void main(String[] args) {
        testarClienteRegularSemDesconto();
        testarPremiumAbaixoDoLimite();
        testarPremiumNoLimite();
        testarComposicaoDeItens();
        testarColecaoExpostaComoImutavel();
        testarValidacoes();
        testarResumoInconsistente();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarClienteRegularSemDesconto() {
        Carrinho carrinho = new Carrinho(CategoriaCliente.REGULAR);
        carrinho.adicionar(produto("Monitor", "1200.00"), 1);
        assertResumo(carrinho.resumir(), "1200.00", "0.00", "1200.00");
    }

    private static void testarPremiumAbaixoDoLimite() {
        Carrinho carrinho = new Carrinho(CategoriaCliente.PREMIUM);
        carrinho.adicionar(produto("Teclado", "199.99"), 1);
        assertResumo(carrinho.resumir(), "199.99", "0.00", "199.99");
    }

    private static void testarPremiumNoLimite() {
        Carrinho carrinho = new Carrinho(CategoriaCliente.PREMIUM);
        carrinho.adicionar(produto("SSD", "100.00"), 2);
        assertResumo(carrinho.resumir(), "200.00", "20.00", "180.00");
    }

    private static void testarComposicaoDeItens() {
        Carrinho carrinho = new Carrinho(CategoriaCliente.PREMIUM);
        carrinho.adicionar(produto("Mouse", "80.50"), 2);
        carrinho.adicionar(produto("Hub USB", "59.90"), 1);
        assertResumo(carrinho.resumir(), "220.90", "22.09", "198.81");
    }

    private static void testarColecaoExpostaComoImutavel() {
        Carrinho carrinho = new Carrinho(CategoriaCliente.REGULAR);
        carrinho.adicionar(produto("Mouse", "80.00"), 1);
        assertThrows(UnsupportedOperationException.class, () ->
                carrinho.itens().add(new ItemCarrinho(produto("Teclado", "100.00"), 1)));
    }

    private static void testarValidacoes() {
        assertThrows(IllegalArgumentException.class, () -> new Carrinho(null));
        assertThrows(IllegalArgumentException.class, () -> produto(" ", "10.00"));
        assertThrows(IllegalArgumentException.class, () -> produto("Mouse", "-1.00"));
        assertThrows(IllegalArgumentException.class, () -> new ItemCarrinho(produto("Mouse", "10.00"), 0));
    }

    private static void testarResumoInconsistente() {
        assertThrows(IllegalArgumentException.class, () -> new ResumoCarrinho(
                new BigDecimal("100.00"), new BigDecimal("20.00"), new BigDecimal("90.00")));
    }

    private static Produto produto(String nome, String preco) {
        return new Produto(nome, new BigDecimal(preco));
    }

    private static void assertResumo(ResumoCarrinho resumo, String subtotal, String desconto, String total) {
        assertDecimal(new BigDecimal(subtotal), resumo.subtotal());
        assertDecimal(new BigDecimal(desconto), resumo.desconto());
        assertDecimal(new BigDecimal(total), resumo.total());
    }

    private static void assertDecimal(BigDecimal esperado, BigDecimal atual) {
        if (esperado.compareTo(atual) != 0) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
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
    private interface Executavel { void executar(); }
}
