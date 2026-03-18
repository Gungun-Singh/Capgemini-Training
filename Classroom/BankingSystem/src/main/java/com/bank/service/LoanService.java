package com.bank.service;

import com.bank.dto.LoanRequestDto;
import com.bank.entity.Loan;
import java.util.List;

public interface LoanService {
    Loan applyLoan(LoanRequestDto dto);
    List<Loan> getLoansByAccount(Integer accountId);
    List<Loan> getApprovedLoans();
}