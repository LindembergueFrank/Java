package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Installment {
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate dueDate;
    private Double amount;

    public Installment(){}

    public Installment(LocalDate dueDate, Double amount) {
        this.dueDate = dueDate;
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return dueDate.format(formato) + " - " + String.format("%.2f", amount);

    }
}
