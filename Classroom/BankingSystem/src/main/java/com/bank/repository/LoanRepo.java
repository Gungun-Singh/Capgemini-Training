package com.bank.repository;

import com.bank.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LoanRepo extends JpaRepository<Loan, String> {
    List<Loan> findByAccountId(Integer accountId);
    List<Loan> findByStatus(String status);
}