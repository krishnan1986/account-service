package com.example.account.service;

import com.example.account.model.Account;

import java.util.List;

public interface AccountOperations {
    public List<Account> getAllCustomerAccounts();
    public Account getAccountById(String accountId);
    public void addAccount(Account account);
    public void deleteAccount(String accountId);
    public void updateAccount(String accountId);
}
