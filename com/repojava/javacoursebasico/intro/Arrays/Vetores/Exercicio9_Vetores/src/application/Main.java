package application;

import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String name;
        String nameMaiorIdade = null;
        int idade;
        int maiorIdade = 0;


        System.out.print("Quantas pessoas voce vai digitar? ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        Pessoa[] person = new Pessoa[quantidade];

        for (int i=0; i<person.length; i++) {
            System.out.println("Digite o nome da " + (i+1) + "a pessoa:");
            System.out.print("Nome: ");
            name = sc.next();
            System.out.print("Idade: ");
            idade = sc.nextInt();
            person[i] = new Pessoa(name, idade);
        }

        for (int i=0; i<person.length; i++) {
            if (person[i].getIdade() > maiorIdade) {
                maiorIdade = person[i].getIdade();
                nameMaiorIdade = person[i].getNome();
            }
        }

        System.out.println();
        System.out.println("PESSOA MAIS VELHA: " + nameMaiorIdade);

        sc.close();
    }
}