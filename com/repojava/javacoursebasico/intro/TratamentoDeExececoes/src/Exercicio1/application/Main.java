package Exercicio1.application;

import Exercicio1.model.entities.Account;
import Exercicio1.model.exceptions.AccountExecption;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try{
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            String holder = sc.next();
            sc.nextLine();
            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account conta = new Account(number, holder, initialBalance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double withdrawAmount = sc.nextDouble();
            conta.withdraw(withdrawAmount);
            System.out.printf("New balance: %.2f%n", conta.getBalance());

        }
        catch (AccountExecption e){
            System.out.print("Withdraw error: " + e.getMessage());
        }
        catch (RuntimeException e) {
            System.out.println("Unexpected error");
        }


        sc.close();
    }
}