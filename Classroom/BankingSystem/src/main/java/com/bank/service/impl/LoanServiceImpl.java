package com.bank.service.impl;

import com.bank.dto.LoanRequestDto;
import com.bank.entity.Account;
import com.bank.entity.Loan;
import com.bank.exception.InvalidOperationException;
import com.bank.repository.LoanRepo;
import com.bank.service.AccountService;
import com.bank.service.LoanService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LoanServiceImpl implements LoanService {

    private final LoanRepo loanRepo;
    private final AccountService accountService;

    public LoanServiceImpl(LoanRepo loanRepo, AccountService accountService) {
        this.loanRepo = loanRepo;
        this.accountService = accountService;
    }

    @Override
    public Loan applyLoan(LoanRequestDto dto) {
        Account account = accountService.getAccount(dto.getAccountId());

        if (!account.isActive())
            throw new InvalidOperationException("Account is not active");

        List<Loan> activeLoans = loanRepo.findByAccountId(dto.getAccountId())
                .stream()
                .filter(l -> l.getStatus().equals("APPROVED"))
                .toList();

        if (activeLoans.size() >= 3)
            throw new InvalidOperationException("Max 3 active loans allowed");

        if (dto.getAmount() > account.getBalance() * 5)
            throw new InvalidOperationException("Loan cannot exceed 5x account balance");

        Loan loan = new Loan();
        loan.setLoanId(UUID.randomUUID().toString());
        loan.setAmount(dto.getAmount());
        loan.setStatus("PENDING");
        loan.setAccount(account);
        return loanRepo.save(loan);
    }

    @Override
    public List<Loan> getLoansByAccount(Integer accountId) {
        accountService.getAccount(accountId);
        return loanRepo.findByAccountId(accountId);
    }

    @Override
    public List<Loan> getApprovedLoans() {
        return loanRepo.findByStatus("APPROVED");
    }
}