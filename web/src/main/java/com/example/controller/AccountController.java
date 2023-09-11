package com.example.controller;

import com.example.entity.AccountEntity;
import com.example.services.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @PostMapping("/new")
    public void createAccount(@RequestBody AccountEntity accountEntity){
        accountService.createAccount(accountEntity);
    }


    @GetMapping("/get/{accountNumber}")
    public Optional<AccountEntity> getAccount(@PathVariable("accountNumber") String accountNumber){
        return accountService.getAccount(accountNumber);
    }


}

