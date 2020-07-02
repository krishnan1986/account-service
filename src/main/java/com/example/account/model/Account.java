package com.example.account.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/*@NoArgsConstructor
@AllArgsConstructor*/
@Getter
@Setter
public class Account {
    private Integer accountId;
    private String accountType;
    private BigDecimal balance;

    private String dailyLimit;

    private String dbPort;

    private String decryptedValue;

    public Account(Integer accountId, String accountType, BigDecimal balance) {
        this.accountId = accountId;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Account() {
    }

  /*  public Integer getAccountId() {
        return accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }*/
}
