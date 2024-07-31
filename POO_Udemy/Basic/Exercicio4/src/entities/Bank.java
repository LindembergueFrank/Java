package entities;

public class Bank {
    private static final double tax = 5.00;

    private String nameClient;
    private Integer accountNumber;
    private double accountBalance;

    public Bank(String nameClient, int accountNumber) {
        this.nameClient = nameClient;
        this.accountNumber = accountNumber;
    }

    public Bank(String nameClient, Integer accountNumber, double accountBalance) {
        this.nameClient = nameClient;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account " + getAccountNumber() + ", Holder: " + getNameClient()
                + ", Balance: $ " + String.format("%.2f", getAccountBalance());
    }

    public void deposit(double amount) {
        accountBalance += amount;
    }

    public double withdrawValue(double amount ) {
        return accountBalance -= amount + tax;
    }
}
