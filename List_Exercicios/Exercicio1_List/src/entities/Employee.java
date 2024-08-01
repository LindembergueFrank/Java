package entities;

public class Employee {
    private Integer id;
    private String name;
    private Double salary;

    public Employee(Integer id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getSalary() {
        return salary;
    }

    public double increaseSalary(double percentage) {
        double aumment = percentage/100.0;
        return salary += salary * aumment;
    }

    @Override
    public String toString() {
        return getId() + ", "
                + getName() + ", " + String.format("%.2f", getSalary());
    }
}
