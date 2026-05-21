package org.finance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinanceManager {
    private final List<Transaction> transactions;
    private double balance;

    public FinanceManager(){
        this.transactions = new ArrayList<>();
        this.balance = 0.0;
    }

    public void addTransaction(Transaction transaction){
        this.transactions.add(transaction);

        if(transaction.getType() == TransactionType.INCOME){
            balance += transaction.getAmount();
        }else{
            balance -= transaction.getAmount();
        }
    }

    public List<Transaction> getAllTransactions(){
        return Collections.unmodifiableList(transactions);
    }

    public double getBalance(){
        return balance;
    }

    public List<Transaction> getTransactionByType(TransactionType type){
        return transactions.stream().filter(t -> t.getType() == type).collect(java.util.stream.Collectors.toList());
    }
}
