package Exercicio13;

public class Teste {
    public static void main(String[] args) {
        Animal animal = new Animal("Camelo", 150, 4, "Amarelo", "Terra", 2.0);

        Peixe peixe = new Peixe("Tubarão", 300, 0, "Cinzento", "Mar", 1.5, "Barbatanas e cauda");

        Mamifero mamifero = new Mamifero("Urso-do-canadá", 180, 4, "Vermelho", "Terra", 0.5, "Mel");

        System.out.println("Zoo");
        System.out.println("------------------");
        System.out.println(animal);
        System.out.println("------------------");
        System.out.println(peixe);
        System.out.println("------------------");
        System.out.println(mamifero);
        System.out.println("------------------");
    }
}
