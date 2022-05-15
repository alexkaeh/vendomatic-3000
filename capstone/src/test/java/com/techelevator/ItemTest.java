package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    Item item5 = new Item("A1", "test item", 1.00, "Gum", 5);
    Item item0 = new Item("A1", "test item", 1.00, "Gum", 0);

    Money money5 = new Money(5);
    Money money0 = new Money(0);

    public ItemTest() {
    }

    @Test
    public void test_dispense_item_sold_out() {
        String expected = "   > *** SOLD OUT *** <";
        Assert.assertEquals(expected, item0.dispenseItem(money5));
    }

    @Test
    public void test_dispense_item_no_money() {
        String expected = "Insufficient funds, please insert more money\n";
        Assert.assertEquals(expected, item5.dispenseItem(money0));
    }

    @Test
    public void test_dispense_item_success() {
        String expected = "Dispensing test item, $1.00\n" +
                "CURRENT BALANCE: $4.00\n" +
                "Chew Chew, Yum!";
        Assert.assertEquals(expected, item5.dispenseItem(money5));
    }

    @Test
    public void test_dispense_item_quantity_reduces_by_one() {
        item5.dispenseItem(money5);
        Assert.assertEquals(4, item5.getQuantity());
    }

}
