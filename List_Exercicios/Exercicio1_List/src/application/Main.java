package application;

import entities.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registered? ");
        int quantidade = sc.nextInt();
        boolean idExiste = false;

        List<Employee> employees = new ArrayList<>();

        for (int i = 1; i <= quantidade; i++) {
            System.out.println("Employee #" + i + ": ");
            System.out.print("Id: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println();

            // Confere se o id já existe
            idExiste = employees.stream().anyMatch(j -> j.getId() == id);

            if (idExiste) {
                System.err.println("ID já existe!");
            } else {
                employees.add(new Employee(id, name, salary));
            }
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        int id = sc.nextInt();

        Employee emp = employees.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null){
            System.out.println("This id does not exist!");
        } else {
            System.out.print("Enter the percentage: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        System.out.println();

        for (Employee e : employees){
            System.out.println(e);
        }

        sc.close();
    }
}