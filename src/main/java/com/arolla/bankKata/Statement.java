package com.arolla.bankKata;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Statement {

    private static final String DATE_AMOUNT_BALANCE = "DATE | AMOUNT | BALANCE";
    private Console console;
    List<Transaction> transactions = new ArrayList();

    public Statement(Console console) {
        this.console = console;
    }

    public void add(Transaction transaction) {
        transactions.add(transaction);
    }

    public void print() {
        console.printLine(DATE_AMOUNT_BALANCE);
        AtomicInteger atomicInteger = new AtomicInteger(0);
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getDate))
                .map(t -> t.print(atomicInteger.addAndGet(t.getAmount())))
                .sorted(Comparator.reverseOrder())
                .forEachOrdered(line -> console.printLine(line));
    }
}
