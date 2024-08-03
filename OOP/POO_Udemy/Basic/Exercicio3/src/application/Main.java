package application;

import entities.Student;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Student student = new Student();
        System.out.print("Name: ");
        student.name = sc.nextLine();

        System.out.println("Type your notes: ");
        student.readNote(student.note);

        System.out.print(student);
        student.checkApproved();

        sc.close();
    }
}