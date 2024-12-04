package com.repojava.estruturadedados.arrays;

import java.util.Arrays;

public class Array {
    private String[] vetor;
    int tamanho;

    public Array(int capacidade) {
        this.vetor = new String[capacidade];
    }

    public void adiciona(String elemento) {
        for (int i=0; i<this.vetor.length; i++) {
            if(null == this.vetor[i]) {
                this.vetor[i] = elemento;
                break;
            }
        }
    }

    public boolean adicionaMelhorado(String elemento) {
        if (tamanho < vetor.length) {
            vetor[tamanho] = elemento;
            tamanho++;
            return true;
        }

        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        return Arrays.toString(vetor);
    }
}
