package application;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Integer> listSetCursoA = new HashSet<>();
        Set<Integer> listSetCursoB = new HashSet<>();
        Set<Integer> listSetCursoC = new HashSet<>();

        System.out.print("How many students for course A? ");
        int quantidadeCursoA = sc.nextInt();

        for (int i = 0; i < quantidadeCursoA; i++) {
            int quantidadeA = sc.nextInt();
            listSetCursoA.add(quantidadeA);
        }

        System.out.print("How many students for course B? ");
        int quantidadeCursoB = sc.nextInt();
        for (int i = 0; i < quantidadeCursoB; i++) {
            int quantidadeB = sc.nextInt();
            listSetCursoB.add(quantidadeB);
        }

        System.out.print("How many students for course C? ");
        int quantidadeCursoC = sc.nextInt();
        for (int i = 0; i < quantidadeCursoC; i++) {
            int quantidadeC = sc.nextInt();
            listSetCursoC.add(quantidadeC);
        }

        Set<Integer> quantidadeTotal = new HashSet<>();
        quantidadeTotal.addAll(listSetCursoA);
        quantidadeTotal.addAll(listSetCursoB);
        quantidadeTotal.addAll(listSetCursoC);

        System.out.println("---------------------------");
        System.out.println("Total number of students: " + quantidadeTotal.size());

        sc.close();
    }
}