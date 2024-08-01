package List.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> carrinho = new ArrayList<>();
    public CarrinhoDeCompras() {
        this.carrinho = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        carrinho.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){

        List<Item> itensParaRemover = new ArrayList<>();

        for(Item item: carrinho){
            if(item.getNome().equalsIgnoreCase(nome)){
                itensParaRemover.add(item);
            }
        }
        carrinho.removeAll(itensParaRemover);
    }

    public double calcularValorTotal(){
        double total = 0.0;
        for(Item item: carrinho){
            for(int i=0; i<item.getQuantidade(); i++){
                total += item.getPreco();
            }
        }
        return total;
    }

    public void exibirItens(){
        for(Item item: carrinho){
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
    }
}
