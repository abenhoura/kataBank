package  com.arolla.bankKata;
public class Account {

    private Statement statement;
    private Clock clock;

    public Account(Statement statement, Clock clock) {
        this.statement=statement;
        this.clock=clock;
    }

    public void deposit(int amount){
        statement.add(new Transaction(amount, clock.date()));
    }

    public void withdrawal(int amount){
        statement.add(new Transaction(-1 * amount, clock.date()));
    }

    public void printStatement(){
        statement.print();
    }

}