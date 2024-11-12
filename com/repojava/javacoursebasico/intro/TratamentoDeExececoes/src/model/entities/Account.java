package model.entities;

import model.exceptions.AccountExecption;

public class Account {
    private Integer number;
    private String holderName;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holderName, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holderName = holderName;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolderName() {
        return holderName;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    private void checkWithdraw(double amount){
        if (amount > getWithdrawLimit()) {
            throw new AccountExecption("The amount exceeds withdraw limit");
        }
        if (amount > getBalance()) {
            throw new AccountExecption("Not enough balance");
        }
    }

    public void withdraw(Double amount) {
        checkWithdraw(amount);
        balance -= amount;
    }
}
