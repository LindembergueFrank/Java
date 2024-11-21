package Exercicio9;

public class Contato {
    String name;
    String telefone;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String obterContatos() {
        return "Nome: " + name + ", Telefone: " + telefone + ", Email: " + email;
    }
}
