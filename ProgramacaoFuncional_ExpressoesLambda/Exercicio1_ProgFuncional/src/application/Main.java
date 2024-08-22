package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            List<Employee> employees = new ArrayList<>();
            String line = br.readLine();

            while(line != null){
                String[] words = line.split(",");
                employees.add(new Employee(words[0], words[1], Double.parseDouble(words[2])));
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();

            System.out.println("Email of people whose salary is more than 2000.00: ");

            List<String> emails = employees.stream()
                    .filter(p -> p.getSalary() > salary)
                    .map(p ->  p.getEmail()).sorted(
                            (email1, email2) -> email1.toUpperCase()
                                    .compareTo(email2.toUpperCase())
                    ).toList();

            emails.forEach(System.out::println);

            double sum = employees.stream()
                    .filter(n -> n.getName().charAt(0) == 'M')
                    .map(n -> n.getSalary())
                    .reduce(0.0, (x, y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));

        }catch (IOException e){
            System.err.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}