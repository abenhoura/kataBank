package com.arolla.bankKata;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClockTest {

    @Test
    public void shoud_format_date() {
        //Arrange
        Clock clock = new Clock();

        //Act
        String result = clock.date();

        //Assert
        assertEquals(10, result.length());
        assertTrue(result.matches("\\d{2}/\\d{2}/\\d{4}"));
    }
}