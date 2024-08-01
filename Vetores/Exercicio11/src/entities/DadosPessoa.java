package entities;

public class DadosPessoa {
    private double altura;
    private char genero;

    public DadosPessoa(double altura, char genero) {
        this.altura = altura;
        this.genero = genero;
    }

    public double getAltura() {
        return altura;
    }

    public char getGenero() {
        return genero;
    }
}
