package Exercicio3;

import Exercicio2.Livro;

public class LivroDeLivraria extends Livro {
    private double precoLivro;
    private int quantidadeDisponivel;

    public LivroDeLivraria(String titulo, String autor, String editora, int anoDePublicacao, int numeroDoVolume, double precoLivro, int quantidadeDisponivel) {
        super(titulo, autor, editora, anoDePublicacao, numeroDoVolume);
        this.precoLivro = precoLivro;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public double getPrecoLivro() {
        return precoLivro;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    @Override
    public String toString() {
        return "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nEditora: " + getEditora() +
                "\nAno de publicação: " + getAnoDePublicacao() + "\nNumero do volume: " + getNumeroDoVolume() +
                "\nPreco: " + precoLivro + "\nQuantidade: " + quantidadeDisponivel;
    }
}
