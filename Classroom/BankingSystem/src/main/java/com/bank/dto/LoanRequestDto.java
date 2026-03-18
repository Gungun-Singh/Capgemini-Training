package com.bank.dto;

import jakarta.validation.constraints.Positive;

public class LoanRequestDto {

    private Integer accountId;

    @Positive(message = "Loan amount must be positive")
    private double amount;

    public LoanRequestDto() {}
    public LoanRequestDto(Integer accountId, double amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public Integer getAccountId() { return accountId; }
    public void setAccountId(Integer accountId) { this.accountId = accountId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}