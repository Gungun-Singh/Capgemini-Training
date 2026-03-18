package com.capgi.bank.entity.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponseDto {

    private Long balance;
    private Integer accountId;
    private AccountType accountType;
    private String holderEmail;
    private String accountHolderName;
}
