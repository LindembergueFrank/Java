package Exercicio8;

public class ConversaoDeUnidadesDeArea {
    public void metroParaPes(double metros){
        System.out.print("Convertendo " + metros + "(metros²) para pés²: ");
        System.out.printf("%.2f", (metros * 10.76));
    }
    public void pesParaCentimetros(double pes){
        System.out.print("Convertendo " + pes + "(pés²) para centímetros²: ");
        System.out.printf("%.2f", (pes * 929));
    }
    public void milhaParaAcres(double milhas){
        System.out.print("Convertendo: " + milhas + "(milha²) para acres: ");
        System.out.printf("%.2f", (milhas * 0.95));
    }
    public void acresParaPes(double acres){
        System.out.print("Convertendo " + acres + "(acre) para pés²: ");
        System.out.printf("%.2f", (acres * 43.560));
    }
}
