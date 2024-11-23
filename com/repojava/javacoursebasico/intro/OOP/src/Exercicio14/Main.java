package Exercicio14;

public class Main {
    public static void main(String[] args) {
        Cilindro cilindro = new Cilindro("Cilindro", "Azul", 12, 4);
        Circulo circulo = new Circulo("Circulo", "Vermelho", 5);
        Cubo cubo = new Cubo("Cubo", "Verde", 9);
        Piramide piramide = new Piramide("Piramide", "Marrom", 6, 9, 3);
        Quadrado quadrado = new Quadrado("Quadrado", "Aquarela", 4, 3);
        Triangulo triangulo = new Triangulo("Triangulo", "Rosa", 3, 7);

        FiguraGeometrica[] figuraGeometricas = new FiguraGeometrica[6];
        figuraGeometricas[0] = cilindro;
        figuraGeometricas[1] = circulo;
        figuraGeometricas[2] = cubo;
        figuraGeometricas[3] = piramide;
        figuraGeometricas[4] = quadrado;
        figuraGeometricas[5] = triangulo;

        System.out.println("Figuras geométricas criadas: ");
        System.out.println("-------------");
        for (FiguraGeometrica figura : figuraGeometricas) {
            System.out.println(figura);
            System.out.println("-------------");
        }

    }
}
