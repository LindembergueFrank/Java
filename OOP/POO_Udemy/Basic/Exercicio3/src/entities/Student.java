package entities;

import java.util.Scanner;

public class Student {
    public String name;
    public double note;
    private double finalNote = 0.0d;

    public void readNote(double note) {
        Scanner sc = new Scanner(System.in);
        for (int i=1; i<=3; i++) {
            note = sc.nextDouble();
            finalNote += note;
        }
        sc.close();
    }

    public void checkApproved () {
        if(finalNote > 60.0){
            System.out.println("PASS");
        }else if(finalNote < 60.0){
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f POINTS%n", (60.0-finalNote));
        }
    }

    public String toString(){
        return "FINAL GRADE = " + String.format("%.2f%n", finalNote);
    }
}
