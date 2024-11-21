package Exercicio10;

import java.util.Arrays;

public class Aluno {
    private String nome;
    private String matricula;
    private double[] notas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public double calcularMedia() {
        double media = 0;

        for (double nota : notas) {
            media += nota;
        }

        return media = media /4;
    }

    public String imprimir() {
        String info = "\nNome do aluno: " + nome + "\n"
        + "Matricula: " + matricula + "\n"
        + "Notas do aluno: ";

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
            info += nota + " ";
        }

        double media = soma /4;
        info += "\nMedia: " + media;

        if (media >= 7) {
            info += " Aprovado por média";
        }
        else if (media < 7 && media >= 6) {
            info += " Aprovado por nota";
        }
        else if (media < 6) {
            info += " Prova de reposição";
        }
        else {
            info += " Aluno reprovado";
        }

        return info;
    }
}
