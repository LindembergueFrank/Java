package application;

import entities.Aluno;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantos alunos serao digitados? ");
        int quantidade = sc.nextInt();
        sc.nextLine();
        Aluno[] aluno = new Aluno[quantidade];

        String nome = null;
        double notaUm = 0.0;
        double notaDois = 0.0;
        double[] media = new double[quantidade];

        for (int i = 0; i < aluno.length; i++) {
            System.out.println("Digite nome, primeira e segunda nota do "
                    + (i+1) + "o aluno:");
            nome = sc.nextLine();
            notaUm = sc.nextDouble();
            notaDois = sc.nextDouble();
            sc.nextLine();

            aluno[i] = new Aluno(nome, notaUm, notaDois);
            media[i]= ((aluno[i].getPrimeiraNota() + aluno[i].getSegundaNota())/2);
        }

        System.out.println();
        System.out.println("Alunos aprovados:");
        for (int i = 0; i < aluno.length; i++) {
            if (media[i] >= 6.0) {
                System.out.println(aluno[i].getNome());
            }
        }

        sc.close();
    }
}