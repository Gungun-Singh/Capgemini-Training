package Multithr;

class BankAccount {

    private int balance = 1000;

    public synchronized void withdraw(int amount) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " entered withdraw");

        while (balance < amount) {
            System.out.println("Insufficient balance");
            System.out.println(Thread.currentThread().getName() + " is waiting");
            wait();
            System.out.println(Thread.currentThread().getName() + " got notified");
        }

        balance = balance - amount;

        System.out.println(Thread.currentThread().getName() + " completed withdrawal");
        System.out.println("Remaining balance = " + balance);
        System.out.println(Thread.currentThread().getName() + " releasing lock");
    }

    public synchronized void deposit(int amount) {

        System.out.println(Thread.currentThread().getName() + " entered deposit");

        balance = balance + amount;

        System.out.println(Thread.currentThread().getName() + " deposited " + amount);
        System.out.println("Updated balance = " + balance);

        notify();

        System.out.println(Thread.currentThread().getName() + " sent notify signal");
        System.out.println(Thread.currentThread().getName() + " releasing lock");
    }
}

class WithdrawThread extends Thread {

    private BankAccount account;
    private int amount;

    WithdrawThread(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        try {
            account.withdraw(amount);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}

class DepositThread extends Thread {

    private BankAccount account;
    private int amount;

    DepositThread(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public void run() {
        account.deposit(amount);
    }
}

public class Banking {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        WithdrawThread t1 = new WithdrawThread(account, 1500);
        DepositThread t2 = new DepositThread(account, 1000);

        t1.setName("Withdraw-Thread");
        t2.setName("Deposit-Thread");

        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        t2.start();
    }
}
