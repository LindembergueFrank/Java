package Exercicio2;

public class Contato {
    private String name;
    private String phone;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
}
