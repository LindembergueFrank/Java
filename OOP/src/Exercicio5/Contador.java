package Exercicio5;

import java.util.Scanner;

public class Contador {
    private int contador = 0;

    public Contador() {
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public void incrementar(int x) {
        System.out.println("Incrementando o valor de " + x );

        contador += x;
    }
    public void decrementar() {
        System.out.println("Decrementando");
        contador--;
    }

    public void zerarContador() {
        contador = 0;
    }
 }
