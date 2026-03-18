package com.bank.controller;

import com.bank.dto.TransferDto;
import com.bank.entity.Transaction;
import com.bank.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/deposit/{accountId}")
    public ResponseEntity<Transaction> deposit(@PathVariable Integer accountId,
                                               @RequestParam double amount) {
        return ResponseEntity.ok(transactionService.deposit(accountId, amount));
    }

    @PostMapping("/withdraw/{accountId}")
    public ResponseEntity<Transaction> withdraw(@PathVariable Integer accountId,
                                                @RequestParam double amount) {
        return ResponseEntity.ok(transactionService.withdraw(accountId, amount));
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transfer(@RequestBody TransferDto dto) {
        transactionService.transfer(dto.getFromAccountId(), dto.getToAccountId(), dto.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }

    @GetMapping("/statement/{accountId}")
    public ResponseEntity<List<Transaction>> getMiniStatement(@PathVariable Integer accountId) {
        return ResponseEntity.ok(transactionService.getMiniStatement(accountId));
    }
}