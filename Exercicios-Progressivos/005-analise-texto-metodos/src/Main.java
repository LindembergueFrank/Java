import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite uma frase: ");
            String frase = scanner.nextLine();

            if (frase.isBlank()) {
                System.out.println("Frase invalida. Informe ao menos um caractere nao vazio.");
                return;
            }

            String normalizada = normalizarEspacos(frase);

            System.out.printf("Texto normalizado: %s%n", normalizada);
            System.out.printf("Palavras: %d%n", contarPalavras(normalizada));
            System.out.printf("Vogais: %d%n", contarVogais(normalizada));
            System.out.printf("Digitos: %d%n", contarDigitos(normalizada));
            System.out.printf("Palindromo: %s%n", ehPalindromo(normalizada) ? "sim" : "nao");
        }
    }

    static String normalizarEspacos(String texto) {
        return texto.trim().replaceAll("\\s+", " ");
    }

    static int contarPalavras(String textoNormalizado) {
        if (textoNormalizado.isEmpty()) {
            return 0;
        }
        return textoNormalizado.split(" ").length;
    }

    static int contarVogais(String texto) {
        int total = 0;
        String minusculo = texto.toLowerCase(Locale.ROOT);

        for (int i = 0; i < minusculo.length(); i++) {
            char caractere = minusculo.charAt(i);
            if ("aeiouáàâãéêíóôõúü".indexOf(caractere) >= 0) {
                total++;
            }
        }
        return total;
    }

    static int contarDigitos(String texto) {
        int total = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (Character.isDigit(texto.charAt(i))) {
                total++;
            }
        }
        return total;
    }

    static boolean ehPalindromo(String texto) {
        int esquerda = 0;
        int direita = texto.length() - 1;

        while (esquerda < direita) {
            char inicio = texto.charAt(esquerda);
            char fim = texto.charAt(direita);

            if (!Character.isLetterOrDigit(inicio)) {
                esquerda++;
                continue;
            }
            if (!Character.isLetterOrDigit(fim)) {
                direita--;
                continue;
            }
            if (Character.toLowerCase(inicio) != Character.toLowerCase(fim)) {
                return false;
            }

            esquerda++;
            direita--;
        }
        return true;
    }
}
