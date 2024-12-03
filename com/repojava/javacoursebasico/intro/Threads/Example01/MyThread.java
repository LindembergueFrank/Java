package com.repojava.javacoursebasico.intro.Threads.Example01;

public class MyThread extends Thread{
    private String name;
    private int timer;

    public MyThread(String name, int timer) {
        this.name = name;
        this.timer = timer;
        start();
    }

    public void run() {

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(name + ", contador: " + i);
                Thread.sleep(timer);
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println(name + " acabou a execução!");
        }
    }
}
