package com.repojava.javacoursebasico.intro.Threads.Example01;

public class TesteThread {
    public static void main(String[] args) {
        MyThread thread = new MyThread("Thread01", 600);
        MyThread thread2 = new MyThread("Thread02", 750);
        MyThread thread3 = new MyThread("Thread03", 900);

    }
}
