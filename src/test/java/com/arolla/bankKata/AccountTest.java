package com.arolla.bankKata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    Clock clock;

    @Mock
    Statement statement;


    @Test
    public void shoudAddTransactionWhenDeposit() {
        //Arrange
        Account account = new Account(statement, clock);
        when(clock.date()).thenReturn("01/01/2020");

        //Act
        account.deposit(100);

        //Assert
        verify(statement).add(new Transaction(100, "01/01/2020"));
    }

    @Test
    public void shoudAddTransactionWhenWithdrawal() {
        //Arrange
        Account account = new Account(statement, clock);
        when(clock.date()).thenReturn("01/01/2020");

        //Act
        account.withdrawal(100);

        //Assert
        verify(statement).add(new Transaction(-100, "01/01/2020"));
    }

    @Test
    public void shoudCallPrintStatment() {
        //Arrange
        Account account = new Account(statement, clock);

        //Act
        account.printStatement();

        //Assert
        verify(statement).print();
    }
}