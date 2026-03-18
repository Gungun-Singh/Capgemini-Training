package com.bank.core.entity;

import jakarta.persistence.*;

@Entity
public class Loan {

    @Id
    private String loanId;

    private double amount;
    private String status; // APPROVED, REJECTED, PENDING

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
