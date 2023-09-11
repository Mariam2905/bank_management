package com.example.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table (name = "transaction")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transactionType;
    private String sender;
    private String receiver;
    private Date date;

    public TransactionEntity() {
    }

    public TransactionEntity(String transactionType, String sender, String receiver, Date date) {
        this.transactionType = transactionType;
        this.sender = sender;
        this.receiver = receiver;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
