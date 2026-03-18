package com.capgi.bank.entity;

import com.capgi.bank.entity.dto.AccountType;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    private String accountHolderName;

    private String holderEmail;
    private String accountSecureKey;
    private Long balance;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
