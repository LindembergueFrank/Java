package Exercicio2;

import java.util.Arrays;

public class Agenda {
    private Contato[] contatos;

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public void addContato(Contato c) {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] == null) {
                contatos[i] = c;
            }
        }
    }
}
