package Exercicio5;

public class Main {
    public static void main(String[] args) {
        Contador contador = new Contador();


        contador.incrementar(3);
        System.out.println(contador.getContador());

        contador.incrementar(2);
        System.out.println(contador.getContador());

        contador.decrementar();
        System.out.println(contador.getContador());

        contador.zerarContador();
        System.out.println(contador.getContador());
    }
}
