package com.bank.service;

import com.bank.entity.Transaction;
import java.util.List;

public interface TransactionService {
    Transaction deposit(Integer accountId, double amount);
    Transaction withdraw(Integer accountId, double amount);
    void transfer(Integer fromId, Integer toId, double amount);
    List<Transaction> getMiniStatement(Integer accountId);
}