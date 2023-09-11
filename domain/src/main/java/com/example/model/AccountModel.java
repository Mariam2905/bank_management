package com.example.model;

public class AccountModel {

    private String accountNumber;
    private Double accountBalance;
    private String currency;

    public AccountModel() {
    }

    public AccountModel(String accountNumber, Double accountBalance, String currency) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.currency = currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
