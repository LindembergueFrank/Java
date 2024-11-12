package Exercicio2;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private int anoDePublicacao;
    private int numeroDoVolume;

    public Livro(String titulo, String autor, String editora, int anoDePublicacao, int numeroDoVolume) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.anoDePublicacao = anoDePublicacao;
        this.numeroDoVolume = numeroDoVolume;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }

    public int getNumeroDoVolume() {
        return numeroDoVolume;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\nAutor: " + autor + "\nEditora: " + editora +
                "\nAno de publicação: " + anoDePublicacao + "\nNumero do volume: " + numeroDoVolume;
    }
}
