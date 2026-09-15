import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Carrinho carrinho = new Carrinho(CategoriaCliente.PREMIUM);
        carrinho.adicionar(new Produto("Teclado mecanico", new BigDecimal("180.00")), 1);
        carrinho.adicionar(new Produto("Mouse", new BigDecimal("90.00")), 1);

        ResumoCarrinho resumo = carrinho.resumir();
        System.out.println("Subtotal: R$ " + resumo.subtotal());
        System.out.println("Desconto: R$ " + resumo.desconto());
        System.out.println("Total: R$ " + resumo.total());
    }
}
