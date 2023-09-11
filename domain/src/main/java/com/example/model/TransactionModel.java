package com.example.model;

import java.util.Date;

public class TransactionModel {

    private String transactionType;
    private String sender;
    private String receiver;
    private Date date;

    public TransactionModel() {
    }

    public TransactionModel(String transactionType, String sender, String receiver, Date date) {
        this.transactionType = transactionType;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
