package com.bank.service.impl;

import com.bank.dto.AccountDto;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.exception.ResourceNotFoundException;
import com.bank.repository.AccountRepo;
import com.bank.service.AccountService;
import com.bank.service.CustomerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepo accountRepo;
    private final CustomerService customerService;

    public AccountServiceImpl(AccountRepo accountRepo, CustomerService customerService) {
        this.accountRepo = accountRepo;
        this.customerService = customerService;
    }

    @Override
    public Account createAccount(Integer customerId, AccountDto dto) {
        Customer customer = customerService.getCustomerById(customerId);
        Account account = new Account();
        account.setType(dto.getType());
        account.setBalance(dto.getBalance());
        account.setActive(true);
        account.setCustomer(customer);
        return accountRepo.save(account);
    }

    @Override
    public Account getAccount(Integer id) {
        return accountRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found with id: " + id));
    }

    @Override
    public List<Account> getAccountsByCustomer(Integer customerId) {
        customerService.getCustomerById(customerId);
        return accountRepo.findByCustomerId(customerId);
    }

    @Override
    public void deactivateAccount(Integer id) {
        Account account = getAccount(id);
        account.setActive(false);
        accountRepo.save(account);
    }
}