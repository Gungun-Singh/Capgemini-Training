package com.bank.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer txnId;
    private String type;
    private double amount;
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction() {}
    public Transaction(Integer txnId, String type, double amount, LocalDateTime date, Account account) {
        this.txnId = txnId;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    public Integer getTxnId() { return txnId; }
    public void setTxnId(Integer txnId) { this.txnId = txnId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}