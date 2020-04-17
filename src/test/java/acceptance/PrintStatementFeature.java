package acceptance;

import com.arolla.bankKata.Account;
import com.arolla.bankKata.Clock;
import com.arolla.bankKata.Console;
import com.arolla.bankKata.Statement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    @Mock
    Clock clock;

    @Mock
    Console console;

    @Test
    public void shouldPrintStatement() {
        //Arrange
        when(clock.date()).thenReturn("01/04/2014", "02/04/2014", "10/04/2014");

        //Act
        Account account = new Account(new Statement(console), clock);

        account.deposit(1000);
        account.withdrawal(100);
        account.deposit(500);

        account.printStatement();


        //Assert
        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
