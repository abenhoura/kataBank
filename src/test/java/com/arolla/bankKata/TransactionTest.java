package com.arolla.bankKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionTest {

    @Test
    public void shoudPrintTransaction() {
        //Arrange

        //Act
        Transaction transaction = new Transaction(100, "02/01/2020");
        String result = transaction.print(100);

        //Assert
        assertEquals("02/01/2020 | 100.00 | 100.00", result);
    }

}