package application;

import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantas pessoas serao digitadas? ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        Pessoa[] person = new Pessoa[quantidade];

        for (int i = 0; i <person.length; i++) {
            System.out.println("Dados da " + (i+1) + "a pessoa: ");
            System.out.print("Nome: ");
            String nome = sc.next();
            System.out.print("Idade: ");
            int idade = sc.nextInt();
            System.out.printf("Altura: ");
            double altura = sc.nextDouble();
            person[i] = new Pessoa(nome, idade, altura);
        }

        double somaAltura = 0.0;
        double menosDezesseis = 0.0;

        for(int i = 0; i < person.length; i++) {
            somaAltura += person[i].getAltura();

            if(person[i].getIdade() < 16){
                menosDezesseis++;
            }
        }
        System.out.println();

        double alturaMedia = somaAltura/person.length;
        double porcentagem = (menosDezesseis/person.length) * 100;

        System.out.printf("Altura média: %.2f%n", alturaMedia);
        System.out.printf("Pessoas com menos de 16 anos: %.1f%%%n", porcentagem);


        for (int i = 0; i < person.length; i++) {
            if(person[i].getIdade() < 16){
                System.out.println(person[i].getNome());
            }
        }

        sc.close();
    }
}