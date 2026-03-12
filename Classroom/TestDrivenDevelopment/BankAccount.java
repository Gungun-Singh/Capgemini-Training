package tdd;

public class BankAccount {

    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {

        if(amount <= 0){
            throw new IllegalArgumentException("Invalid deposit");
        }

        balance += amount;
    }

    public void withdraw(double amount) {

        if(amount > balance){
            throw new IllegalArgumentException("Insufficient funds");
        }

        balance -= amount;
    }
}
