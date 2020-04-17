package com.arolla.bankKata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    private static final String DATE_AMOUNT_BALANCE = "DATE | AMOUNT | BALANCE";

    @Mock
    Console console ;

    @Test
    public void shouldPrintWhenEmptyTransactions() {
        //Arrange
        Statement statement = new Statement(console);

        //Act
        statement.print();

        //Assert
        Mockito.verify(console).printLine(DATE_AMOUNT_BALANCE);
    }

    @Test
    public void shouldPrintStatement() {
        //Arrange
        Statement statement = new Statement(console);

        //Act
        statement.add(new Transaction(100, "02/01/2020"));
        statement.add(new Transaction(200, "10/01/2020"));

        statement.print();

        //Assert
        Mockito.verify(console).printLine("DATE | AMOUNT | BALANCE");
        Mockito.verify(console).printLine("02/01/2020 | 100.00 | 100.00");
        Mockito.verify(console).printLine("10/01/2020 | 200.00 | 300.00");

    }
}