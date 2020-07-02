package com.example.account.controller;

import com.example.account.model.Account;
import com.example.account.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EnableOAuth2Sso
@RefreshScope
@RestController
public class AccountController {
    @Value("${limit}")
    private String dailyLimit;

    @Value("${db.port}")
    private String dbPort;

    @Value("${encrypted.value}")
    private String encryptedValue;

    @Autowired
    private AccountService accountService;

    private static List<Account> accounts = Stream.of(
            new Account(1,"saving",new BigDecimal(1000.00)),
            new Account(2,"current",new BigDecimal(5000.00)),
                    new Account(3,"saving",new BigDecimal(3000.00)))
            .collect(Collectors.toList());

    @GetMapping(value = "/accounts")
    public List<Account> getAllAccounts() throws Exception{
        accounts.forEach(a->a.setDailyLimit(dailyLimit));
        accounts.forEach(a->a.setDbPort(dbPort));
       return accounts;
    }

    @GetMapping(value = "/account/{accountId}")
    public Account getAccountById(@PathVariable String accountId){
        accounts.forEach(a->a.setDailyLimit(dailyLimit));
        accounts.forEach(a->a.setDbPort(dbPort));
        Optional<Account> account =accounts.stream().filter(a->a.getAccountId()==(Integer.parseInt(accountId)))
                .findFirst();

        return account.isPresent()? account.get() : new Account(0,"default account",new BigDecimal(0));
    }

    @PostMapping(value = "/account/add")
    public void addAccount(@RequestBody Account account){
        accounts.forEach(a->a.setDailyLimit(dailyLimit));
        accounts.forEach(a->a.setDbPort(dbPort));
        accounts.add(account);
    }

    @DeleteMapping(value="/account/delete/{accountId}")
    public void deleteAccount(@PathVariable String accountId){
        accounts.forEach(a->a.setDailyLimit(dailyLimit));
        accounts.forEach(a->a.setDbPort(dbPort));
        Optional<Account> filteredAcc=accounts.stream().filter(a->a.getAccountId() == Integer.parseInt(accountId))
                .findFirst();

        Account toBeDelAccount = filteredAcc.orElse(null);
        accounts.remove(toBeDelAccount);

    }

    @PutMapping(value="/account/update")
    public void updateAccount(@RequestBody Account account){
        accounts.forEach(a->a.setDailyLimit(dailyLimit));
        accounts.forEach(a->a.setDbPort(dbPort));
       accounts.removeIf(a->a.getAccountId()== account.getAccountId());
       accounts.add(account);
       
    }


}
