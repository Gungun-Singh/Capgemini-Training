package com.bank.controller;

import com.bank.dto.LoanRequestDto;
import com.bank.entity.Loan;
import com.bank.service.LoanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/apply")
    public ResponseEntity<Loan> applyLoan(@Valid @RequestBody LoanRequestDto dto) {
        return ResponseEntity.ok(loanService.applyLoan(dto));
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Loan>> getLoansByAccount(@PathVariable Integer accountId) {
        return ResponseEntity.ok(loanService.getLoansByAccount(accountId));
    }

    @GetMapping("/approved")
    public ResponseEntity<List<Loan>> getApprovedLoans() {
        return ResponseEntity.ok(loanService.getApprovedLoans());
    }
}