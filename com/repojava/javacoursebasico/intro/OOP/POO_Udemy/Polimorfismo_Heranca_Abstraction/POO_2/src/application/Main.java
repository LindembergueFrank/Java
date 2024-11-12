package application;

import entities.Contribuinte;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner (System.in);

        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();

        List<Contribuinte> contribuintes = new ArrayList<Contribuinte>();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i +  " data");
            System.out.print("Individual or company (i/c)? ");
            char choice = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.next();
            System.out.print("Anual income: ");
            double anualIncome = sc.nextDouble();

            if (choice == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = sc.nextDouble();
                contribuintes.add(new PessoaFisica(name, anualIncome, healthExpenditures));
            }
            else if (choice == 'c'){
                System.out.print("Number of employees: ");
                int numOfEmployees = sc.nextInt();
                contribuintes.add(new PessoaJuridica(name, anualIncome, numOfEmployees));
            }
        }

        double sum = 0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (Contribuinte contribuinte : contribuintes) {
            sum += contribuinte.calculaImposto();
            System.out.println(contribuinte);
        }

        System.out.println();
        System.out.println("TOTAL TAXES: " + sum);
    }
}