package Exercicio10;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Curso curso = new Curso();

        System.out.print("Nome do curso: ");
        curso.setNome(sc.next());
        System.out.print("Horario do curso: ");
        curso.setHorario(sc.next());

        Professor prof = new Professor();
        System.out.print("Nome do professor: ");
        prof.setNome(sc.next());
        System.out.print("Departamento do professor: ");
        prof.setDepartamento(sc.next());

        curso.setProfessor(prof);

        Aluno[] alunos = new Aluno[5];

        for (int i = 0; i < 5; i++) {
            sc.nextLine();

            System.out.println("Aluno " + (i+1));

            System.out.print("Nome do aluno: ");
            String nome = sc.next();

            System.out.print("Matricula do aluno: ");
            String matricula = sc.next();

            double[] notas = new double[4];

            for (int j=0; j<4; j++) {
                System.out.println("Nota " + (j+1));
                notas[j] = sc.nextDouble();
            }

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setMatricula(matricula);
            aluno.setNotas(notas);

            alunos[i] = aluno;

        }
        curso.setAlunos(alunos);

        System.out.println(curso.imprimir());

    }
}
