package com.capgi.bank.entity.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AccountDto {

    private Long balance;
    private AccountType accountType;
    private String holderEmail;
    private String accountSecureKey;
    private String accountHolderName;
}
