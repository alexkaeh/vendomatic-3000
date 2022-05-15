package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoneyTest {

    public MoneyTest() {
    }

    @Test
    public void test_make_change_140() {
        Money money = new Money(1.40);
        String expected = "YOUR CHANGE\n" +
                "Quarters: 5\n" +
                "Dimes: 1\n" +
                "Nickles: 1" + "\n";
        assertEquals(expected, money.makeChange());
    }

    @Test
    public void test_make_change_500() {
        Money money = new Money(5.00);
        String expected = "YOUR CHANGE\n" +
                "Quarters: 20\n" +
                "Dimes: 0\n" +
                "Nickles: 0" + "\n";
        assertEquals(expected, money.makeChange());
    }

    @Test
    public void test_make_change_001() {
        Money money = new Money(0.01);
        String expected = "YOUR CHANGE\n" +
                "Quarters: 0\n" +
                "Dimes: 0\n" +
                "Nickles: 0" + "\n";
        assertEquals(expected, money.makeChange());
    }

    @Test
    public void test_make_change_020() {
        Money money = new Money(0.24);
        String expected = "YOUR CHANGE\n" +
                "Quarters: 0\n" +
                "Dimes: 2\n" +
                "Nickles: 0" + "\n";
        assertEquals(expected, money.makeChange());
    }

    @Test
    public void test_make_change_negative() {
        Money money = new Money(-5.00);
        String expected = "YOUR CHANGE\n" +
                "Quarters: 0\n" +
                "Dimes: 0\n" +
                "Nickles: 0" + "\n";
        assertEquals(expected, money.makeChange());
    }
}
