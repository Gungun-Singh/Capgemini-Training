package com.bank.service;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;
import java.util.List;

public interface AccountService {
    Account createAccount(Integer customerId, AccountDto dto);
    Account getAccount(Integer id);
    List<Account> getAccountsByCustomer(Integer customerId);
    void deactivateAccount(Integer id);
}