package com.bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AccountDto {

    @NotBlank(message = "Account type is required")
    private String type;

    @Positive(message = "Initial balance must be positive")
    private double balance;

    public AccountDto() {}
    public AccountDto(String type, double balance) {
        this.type = type;
        this.balance = balance;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
}