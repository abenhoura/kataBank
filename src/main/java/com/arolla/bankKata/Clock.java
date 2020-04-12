package com.arolla.bankKata;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock {
    public String date() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return simpleDateFormat.format(new Date());
    }
}
