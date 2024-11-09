package Exercicio1;

public class Lampada {
    private String marca;
    private String modelo;
    private int potencia;
    private double preco;
    private int qtdEstoque;

    public Lampada(String marca, String modelo, int potencia, double preco, int qtdEstoque) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.preco = preco;
        this.qtdEstoque = qtdEstoque;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getPotencia() {
        return potencia;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Potencia(W): " + potencia + "\nPreco(R$): " + preco
                + "\nQuantidade em estoque: " + qtdEstoque;
    }
}
