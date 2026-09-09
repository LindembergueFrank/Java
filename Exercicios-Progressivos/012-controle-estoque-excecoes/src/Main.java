public class Main {
    public static void main(String[] args) {
        ItemEstoque teclado = new ItemEstoque("Teclado", 5);

        try {
            teclado.retirar(2);
            System.out.println("Retirada concluida: " + teclado);

            teclado.retirar(4);
        } catch (EstoqueInsuficienteException erro) {
            System.out.println("Operacao recusada: " + erro.getMessage());
            System.out.println("Estoque preservado: " + teclado.getQuantidade());
        }
    }
}
