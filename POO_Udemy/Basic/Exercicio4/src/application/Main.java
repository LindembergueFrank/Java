package application;

import entities.Bank;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String name;
        Integer accountNumber;
        double valueAccount;
        Bank account = null;

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        // Consome a linha restante do int
        sc.nextLine();

        System.out.print("Enter account holder: ");
        name = sc.nextLine();

        System.out.print("Is there na initial deposit (y/n)? ");
        String option = sc.nextLine();

        if (option.equals("y")) {
            System.out.print("Enter initial deposit value: ");
            valueAccount = sc.nextDouble();
            account = new Bank(name, accountNumber, valueAccount);
            account.setAccountBalance(valueAccount);
        }
        else if (option.equals("n")) {
            account = new Bank(name, accountNumber);
        } else {
            System.err.println("Invalid option");
        }

        System.out.println();
        System.out.println("Account data:");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter a deposit value: ");
        valueAccount = sc.nextDouble();
        account.deposit(valueAccount);
        System.out.println("Updated account data:");
        System.out.println(account);

        System.out.println();
        System.out.print("Enter a withdraw value: ");
        valueAccount = sc.nextDouble();
        account.withdrawValue(valueAccount);

        System.out.println("Updated account data:");
        System.out.println(account);

        sc.close();
    }
}