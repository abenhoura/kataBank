package com.arolla.bankKata;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;

public class Transaction {

    private final int amount;
    private final String date;

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public Transaction(int amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public String print(int balance) {
        return date + " | " + formatDecimal(amount) + " | " + formatDecimal(balance);
    }

    private static String formatDecimal(int amount) {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#.00", decimalFormatSymbols);
        return decimalFormat.format(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return amount == that.amount &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + date.hashCode();
        return result;
    }

}

