package Exercicio10.Teste;

import Exercicio10.Aluno;
import Exercicio10.Curso;
import Exercicio10.Professor;

import java.util.Currency;

public class Teste {
    public static void main(String[] args) {

        double[] notas = {10, 8, 5, 9};
        Aluno aluno = new Aluno();
        System.out.println("Testando a classe Aluno");
        aluno.setNome("Victor");
        aluno.setMatricula("1234");
        aluno.setNotas(notas);

        System.out.println("---------");
        System.out.println(aluno.getNome());
        System.out.println(aluno.getMatricula());
        System.out.println("Notas ");
        for (int i = 0; i < aluno.getNotas().length; i++){
            System.out.print(aluno.getNotas()[i] + ", ");
        }

        System.out.println("---------------------");
        Professor professor = new Professor();
        System.out.println("Testando a classe Professor");
        professor.setNome("João");
        professor.setDepartamento("Departamento de Neurociências");

        System.out.println("\nNome do professor: " + professor.getNome());
        System.out.println("Departamento: " + professor.getDepartamento());

        Curso curso = new Curso();
        System.out.println("Testando a classe Curso");
        curso.setNome("Curso de Java");
        curso.setHorario("Everyday");

        System.out.println("\nNome do curso: " + curso.getNome() + ", " + curso.getHorario());
    }
}
