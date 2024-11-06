package application;

import entities.DadosPessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int quantidade = sc.nextInt();
        DadosPessoa[] person = new DadosPessoa[quantidade];

        double altura = 0.0;
        char genero;
        double menorAltura = Double.MAX_VALUE;
        double maiorAltura = Double.MIN_VALUE;
        double somaAltura = 0.0;
        double media = 0.0;
        int quantidadeHomens = 0;
        int quantidadeMulheres = 0;

        for (int i = 0; i < person.length; i++) {
            System.out.print("Altura da " + (i + 1) + "a pessoa: ");
            altura = sc.nextDouble();
            sc.nextLine();
            System.out.print("Genero da " + (i + 1) + "a pessoa: ");
            genero = sc.next().charAt(0);
            person[i] = new DadosPessoa(altura, genero);
        }

        for (int i = 0; i < person.length; i++) {
            if (person[i].getAltura() < menorAltura) {
                menorAltura = person[i].getAltura();
            }
            if (person[i].getAltura() > maiorAltura) {
                maiorAltura = person[i].getAltura();
            }
            if(person[i].getGenero()== 'F') {
                quantidadeMulheres++;
                somaAltura += person[i].getAltura();
            }
            else {
                quantidadeHomens++;
            }
        }

        media = somaAltura / quantidadeMulheres;

        System.out.println();
        System.out.printf("Menor altura = %.2f%n", menorAltura);
        System.out.printf("Maior altura = %.2f%n", maiorAltura);
        System.out.printf("Media das alturas das mulheres = %.2f%n", media);
        System.out.println("Numero de homens: " + quantidadeHomens);


        sc.close();
    }
}