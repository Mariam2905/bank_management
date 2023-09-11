package com.example.services;

import com.example.entity.AccountEntity;
import com.example.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    public void createAccount(AccountEntity accountEntity){
        accountRepository.save(accountEntity);
    }

    public Optional<AccountEntity> getAccount(String accountNumber){
        return accountRepository.findAccountEntityByAccountNumber(accountNumber);
    }

}
