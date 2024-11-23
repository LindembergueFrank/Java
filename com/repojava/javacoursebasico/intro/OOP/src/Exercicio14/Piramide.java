package Exercicio14;

public class Piramide extends Figura3D{

    private double areaLateral;
    private double areaBase;
    private double altura;

    public Piramide(String nome, String cor,double areaLateral, double areaBase, double altura) {
        super(nome, cor);
        this.areaLateral = areaLateral;
        this.areaBase = areaBase;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return areaLateral + areaBase;
    }

    @Override
    public double calcularVolume() {
        return ( (areaBase * altura)/3 );
    }

    @Override
    public String toString() {
        return getNome() + "\nCor: " + getCor() + ", Área lateral: " + areaLateral +
                ", Área Base: " + areaBase + ", Altura: " + altura +
                "\nArea: " + String.format("%.2f", calcularArea() ) + ", Volume: " + String.format("%.2f",calcularVolume());
    }
}
