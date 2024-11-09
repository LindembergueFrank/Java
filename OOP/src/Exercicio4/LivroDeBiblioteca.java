package Exercicio4;

import Exercicio2.Livro;

public class LivroDeBiblioteca extends Livro {
    private char corredor;
    private int secao;
    private String dataEmprestimo;

    public LivroDeBiblioteca(String titulo, String autor, String editora, int anoDePublicacao, int numeroDoVolume, char corredor, int secao, String dataEmprestimo) {
        super(titulo, autor, editora, anoDePublicacao, numeroDoVolume);
        this.corredor = corredor;
        this.secao = secao;
        this.dataEmprestimo = dataEmprestimo;
    }
    public char getCorredor() {
        return corredor;
    }

    public int getSecao() {
        return secao;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    @Override
    public String toString() {
        return "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nEditora: " + getEditora()
                + "\nAno de publicação: " + getAnoDePublicacao() + "\nNumero do volume: " + getNumeroDoVolume()
                + "\nCorredor: " + getCorredor() + "   Seção: " + getSecao() + "   Data de emprestimo: " + getDataEmprestimo();
    }
}
