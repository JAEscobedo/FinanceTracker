package org.finance;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FinanceManagerTest {
    private FinanceManager manager;

    @BeforeEach
    void setUp(){
        manager = new FinanceManager();
    }

    @Test
    void testaddTransaction(){
        Transaction t = new Transaction(100.0,"Salary",TransactionType.INCOME);
        manager.addTransaction(t);

        List<Transaction> transactions = manager.getAllTransactions();
        assertEquals(1, transactions.size(), "Should have exactly 1 transaction");
        assertEquals(t, transactions.get(0));
    }

    @Test
    void testCalculateBalance(){
        manager.addTransaction(new Transaction(100.0,"Salary",TransactionType.INCOME));
        manager.addTransaction(new Transaction(30.0,"Groceries",TransactionType.EXPENSE));
        manager.addTransaction(new Transaction(20.0,"Games",TransactionType.EXPENSE));
        
        // 100 - 30 - 20 = 50
        assertEquals(50.0, manager.getBalance(),"Balance should match");
    }

    @Test
    void testFilterByType(){
        manager.addTransaction(new Transaction(100.0,"Salary",TransactionType.INCOME));
        manager.addTransaction(new Transaction(30.0,"Groceries",TransactionType.EXPENSE));
        
        List<Transaction> expenses = manager.getTransactionByType(TransactionType.EXPENSE);

        assertEquals(1, expenses.size(), "Expenses should match 1");
        assertEquals(TransactionType.EXPENSE, expenses.get(0).getType(), "Transaction type should be EXPENSE");
    }
}
