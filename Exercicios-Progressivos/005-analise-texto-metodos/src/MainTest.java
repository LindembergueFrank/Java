public class MainTest {
    public static void main(String[] args) {
        testarNormalizacao();
        testarContagens();
        testarPalindromos();
        System.out.println("Todos os testes passaram.");
    }

    private static void testarNormalizacao() {
        assertEquals("Java e simples", Main.normalizarEspacos("  Java   e   simples  "));
        assertEquals("uma linha", Main.normalizarEspacos("uma\tlinha"));
    }

    private static void testarContagens() {
        String texto = "Java 21 e legal";
        assertEquals(4, Main.contarPalavras(texto));
        assertEquals(5, Main.contarVogais(texto));
        assertEquals(2, Main.contarDigitos(texto));
        assertEquals(5, Main.contarVogais("Olá, ação"));
    }

    private static void testarPalindromos() {
        assertTrue(Main.ehPalindromo("Socorram-me, subi no onibus em Marrocos"));
        assertTrue(Main.ehPalindromo("Ame a ema"));
        assertFalse(Main.ehPalindromo("Java"));
    }

    private static void assertEquals(Object esperado, Object atual) {
        if (!esperado.equals(atual)) {
            throw new AssertionError("Esperado: " + esperado + ", atual: " + atual);
        }
    }

    private static void assertEquals(int esperado, int atual) {
        if (esperado != atual) {
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
}
