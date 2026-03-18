package com.bank.repository;

import com.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Integer> {
    List<Account> findByCustomerId(Integer customerId);
}