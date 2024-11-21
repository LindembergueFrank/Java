package Exercicio9;

public class Agenda {
    private String nome;
    private Contato[] contatos;


    public Agenda(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public String imprimir() {
        String infoName = "Nome da agenda: " + nome + "\n";

        if (contatos != null) {
            for (Contato c : contatos) {
                infoName += c.obterContatos() + "\n";
            }
        }

        return infoName;
    }
}
