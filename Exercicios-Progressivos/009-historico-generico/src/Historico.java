import java.util.ArrayList;
import java.util.List;

public class Historico<T> {
    private final int capacidadeMaxima;
    private final List<T> itens = new ArrayList<>();

    public Historico(int capacidadeMaxima) {
        if (capacidadeMaxima <= 0) {
            throw new IllegalArgumentException("A capacidade maxima deve ser maior que zero.");
        }
        this.capacidadeMaxima = capacidadeMaxima;
    }

    public void adicionar(T item) {
        if (item == null) {
            throw new IllegalArgumentException("O item deve ser informado.");
        }

        if (itens.size() == capacidadeMaxima) {
            itens.remove(0);
        }
        itens.add(item);
    }

    public T ultimo() {
        if (itens.isEmpty()) {
            return null;
        }
        return itens.get(itens.size() - 1);
    }

    public List<T> listar() {
        return List.copyOf(itens);
    }

    public int tamanho() {
        return itens.size();
    }

    public boolean estaVazio() {
        return itens.isEmpty();
    }
}
