package com.example.account.service;

import com.example.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements AccountOperations{
    @Override
    public List<Account> getAllCustomerAccounts() {
        return null;
    }

    @Override
    public Account getAccountById(String accountId) {
        return null;
    }

    @Override
    public void addAccount(Account account) {

    }

    @Override
    public void deleteAccount(String accountId) {

    }

    @Override
    public void updateAccount(String accountId) {

    }
}
