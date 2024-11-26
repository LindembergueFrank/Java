package Exercicio2;

import java.util.Arrays;

public class Agenda {
    private int maxContatos;
    private Contato[] contatos;

    public Agenda(int maxContatos){
        this.maxContatos = maxContatos;
        contatos = new Contato[maxContatos];
    }



    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public void addContact(String name, long number) throws AgendaCheiaException {
        for (int i=0; i<maxContatos; i++) {
            if (contatos[i] == null) {
                contatos[i] = new Contato();

                contatos[i].setName(name);
                contatos[i].setPhone(number);
                contatos[i].setId(i+1);
                return;
            }
        }

        throw new AgendaCheiaException("Não é possível adicionar mais contatos, agenda está cheia! \nLimite de contatos: " + maxContatos);
    }

    public void consultContact(String name) throws ContatoNaoExisteException {

        for (Contato contato : contatos) {
            if (contato != null && contato.getName().equals(name)) {
                System.out.print("Contato encontrado, " + contato);
                return;
            }
        }

        throw new ContatoNaoExisteException("Nenhum contato com este nome consta na agenda!");
    }

    public void consultAllContacts() throws ContatoNaoExisteException {


        for (Contato c : contatos) {
            if (c == null) {
                throw new ContatoNaoExisteException("Não há contatos nesta agenda!");
            }
            System.out.println(c);
        }
    }
}
