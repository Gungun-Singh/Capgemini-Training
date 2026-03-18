package com.bank.controller;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;
import com.bank.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<Account> createAccount(@PathVariable Integer customerId,
                                                 @Valid @RequestBody AccountDto dto) {
        return ResponseEntity.ok(accountService.createAccount(customerId, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Integer id) {
        return ResponseEntity.ok(accountService.getAccount(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Account>> getAccountsByCustomer(@PathVariable Integer customerId) {
        return ResponseEntity.ok(accountService.getAccountsByCustomer(customerId));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<String> deactivateAccount(@PathVariable Integer id) {
        accountService.deactivateAccount(id);
        return ResponseEntity.ok("Account deactivated successfully");
    }
}