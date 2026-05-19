package org.finance;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class TransactionTest {
    @Test
    void setTransactionCreation(){
        double expectedAmount = 50;
        String expectedDescription = "Groceries";
        TransactionType expectedTransactionType = TransactionType.EXPENSE;

        Transaction transaction = new Transaction(expectedAmount, expectedDescription, expectedTransactionType);

        assertNotNull(transaction.getId(), "Transaction ID should not be null");
        assertEquals(expectedAmount, transaction.getAmount(), "Amount should match");
        assertEquals(expectedDescription, transaction.getDescription(), "Description should match");
        assertEquals(expectedTransactionType, transaction.getType(), "Transaction type should match");
        assertEquals(LocalDate.now(), transaction.getDate());
    }
}
