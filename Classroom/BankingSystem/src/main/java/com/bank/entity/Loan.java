package com.bank.entity;

import jakarta.persistence.*;

@Entity
public class Loan {

    @Id
    private String loanId;
    private double amount;
    private String status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Loan() {}
    public Loan(String loanId, double amount, String status, Account account) {
        this.loanId = loanId;
        this.amount = amount;
        this.status = status;
        this.account = account;
    }

    public String getLoanId() { return loanId; }
    public void setLoanId(String loanId) { this.loanId = loanId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}