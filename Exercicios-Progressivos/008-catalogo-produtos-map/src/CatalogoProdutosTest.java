import java.util.List;

public class CatalogoProdutosTest {
    public static void main(String[] args) {
        testarCadastroEBuscaPorChave();
        testarDuplicidadeNormalizada();
        testarRemocao();
        testarOrdemEEncapsulamento();
        testarValidacoes();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarCadastroEBuscaPorChave() {
        CatalogoProdutos catalogo = new CatalogoProdutos();
        Produto teclado = new Produto("TEC-01", "Teclado", 120.0);

        assertTrue(catalogo.adicionar(teclado));
        assertEquals(1, catalogo.quantidade());
        assertSame(teclado, catalogo.buscarPorCodigo("tec-01"));
        assertSame(teclado, catalogo.buscarPorCodigo("  TEC-01  "));
        assertNull(catalogo.buscarPorCodigo("NAO-EXISTE"));
    }

    private static void testarDuplicidadeNormalizada() {
        CatalogoProdutos catalogo = new CatalogoProdutos();

        assertTrue(catalogo.adicionar(new Produto("MON-01", "Monitor", 900.0)));
        assertFalse(catalogo.adicionar(new Produto("mon-01", "Outro monitor", 800.0)));
        assertEquals(1, catalogo.quantidade());
        assertEquals("Monitor", catalogo.buscarPorCodigo("MON-01").getNome());
    }

    private static void testarRemocao() {
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.adicionar(new Produto("MOU-01", "Mouse", 80.0));

        assertTrue(catalogo.removerPorCodigo("mou-01"));
        assertFalse(catalogo.removerPorCodigo("mou-01"));
        assertEquals(0, catalogo.quantidade());
    }

    private static void testarOrdemEEncapsulamento() {
        CatalogoProdutos catalogo = new CatalogoProdutos();
        catalogo.adicionar(new Produto("A", "Primeiro", 1.0));
        catalogo.adicionar(new Produto("B", "Segundo", 2.0));

        List<Produto> snapshot = catalogo.listarTodos();
        assertEquals("Primeiro", snapshot.get(0).getNome());
        assertEquals("Segundo", snapshot.get(1).getNome());
        assertThrowsUnsupported(() -> snapshot.add(new Produto("C", "Terceiro", 3.0)));
        assertEquals(2, catalogo.quantidade());
    }

    private static void testarValidacoes() {
        assertThrowsIllegalArgument(() -> new Produto(" ", "Valido", 10.0));
        assertThrowsIllegalArgument(() -> new Produto("COD", " ", 10.0));
        assertThrowsIllegalArgument(() -> new Produto("COD", "Valido", -0.01));

        CatalogoProdutos catalogo = new CatalogoProdutos();
        assertThrowsIllegalArgument(() -> catalogo.adicionar(null));
        assertNull(catalogo.buscarPorCodigo(" "));
        assertFalse(catalogo.removerPorCodigo(null));
    }

    private static void assertEquals(int esperado, int atual) {
        if (esperado != atual) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertEquals(String esperado, String atual) {
        if (!esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertTrue(boolean valor) {
        if (!valor) {
            throw new AssertionError("Esperado verdadeiro, mas foi falso.");
        }
    }

    private static void assertFalse(boolean valor) {
        if (valor) {
            throw new AssertionError("Esperado falso, mas foi verdadeiro.");
        }
    }

    private static void assertNull(Object valor) {
        if (valor != null) {
            throw new AssertionError("Esperado null, mas recebeu: " + valor);
        }
    }

    private static void assertSame(Object esperado, Object atual) {
        if (esperado != atual) {
            throw new AssertionError("Esperava a mesma instancia.");
        }
    }

    private static void assertThrowsIllegalArgument(Runnable acao) {
        try {
            acao.run();
            throw new AssertionError("Era esperada IllegalArgumentException.");
        } catch (IllegalArgumentException expected) {
            // comportamento esperado
        }
    }

    private static void assertThrowsUnsupported(Runnable acao) {
        try {
            acao.run();
            throw new AssertionError("Era esperada UnsupportedOperationException.");
        } catch (UnsupportedOperationException expected) {
            // comportamento esperado
        }
    }
}
