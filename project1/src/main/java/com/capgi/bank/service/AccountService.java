package com.capgi.bank.service;

import com.capgi.bank.entity.dto.AccountDto;
import com.capgi.bank.entity.dto.AccountResponseDto;
import com.capgi.bank.repository.AccountRepository;
import org.springframework.http.ResponseEntity;

public interface    AccountService {

    void createAccount(AccountDto accountDto);

    AccountResponseDto getAccountById(Integer id);
}
