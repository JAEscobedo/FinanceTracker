package org.finance;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private final String id;
    private final double amount;
    private final String description;
    private final TransactionType type;
    private final LocalDate date;

    public Transaction(double amount, String description, TransactionType type){
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.date = LocalDate.now();
    }

    public String getId(){
        return id;
    }

    public double getAmount(){
        return amount;
    }

    public String getDescription(){
        return description;
    }

    public TransactionType getType(){
        return type;
    }

    public LocalDate getDate(){
        return date;
    }
}
