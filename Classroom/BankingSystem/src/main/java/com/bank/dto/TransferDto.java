package com.bank.dto;

import jakarta.validation.constraints.Positive;

public class TransferDto {

    private Integer fromAccountId;
    private Integer toAccountId;

    @Positive(message = "Transfer amount must be positive")
    private double amount;

    public TransferDto() {}
    public TransferDto(Integer fromAccountId, Integer toAccountId, double amount) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
    }

    public Integer getFromAccountId() { return fromAccountId; }
    public void setFromAccountId(Integer fromAccountId) { this.fromAccountId = fromAccountId; }
    public Integer getToAccountId() { return toAccountId; }
    public void setToAccountId(Integer toAccountId) { this.toAccountId = toAccountId; }
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}