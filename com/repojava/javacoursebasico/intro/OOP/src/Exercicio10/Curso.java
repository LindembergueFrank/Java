package Exercicio10;

import java.util.Arrays;

public class Curso {
    private String nome;
    private String horario;
    private Professor professor;
    private Aluno[] alunos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public double calcularMediaTurma() {
        double media = 0;
        for (Aluno aluno : alunos) {
            if (aluno != null) {
                media += aluno.calcularMedia();
            }
        }
        return media / alunos.length;
    }

    public String imprimir() {
        String info = "Nome do curso: " + nome + "\n";

        if (professor != null) {
            info += professor.imprimir();
        }
        if (alunos != null) {
            System.out.println("-----Alunos-----");
            for (Aluno aluno : alunos) {
                if (aluno != null) {
                    info += aluno.imprimir();
                }
            }

            info += "\nMédia da turma = " + calcularMediaTurma();
        }
        return info;
    }
}
