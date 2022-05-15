package com.techelevator;

/*
 * This serves as a container for each individual item in the vending machine. It serves to track each
 * "slot" in the vending machine, and will report "sold out" if a slot is empty. Uses the 'quantity'
 *  field to track multiple of each item.
 *
 * Fields declared and constructed in the order found in vendingmachine.csv
 *
 * Quantity is initialized to 5 when Inventory.generateList() calls the item constructor.
 */

import lombok.Getter;

import java.text.DecimalFormat;

public class Item {
    public static DecimalFormat df = new DecimalFormat("$0.00"); // TODO CurrencyFormat


    @Getter
    private final String location;
    @Getter
    private final String name;
    private final double price;
    private final String category;
    @Getter // For unit testing access to variables
    private int quantity;

    public Item(String location, String name, double price, String category, int quantity) {
        this.location = location;
        this.name = name;
        this.price = price;
        this.quantity = quantity;

        switch (category) {
            case "Chip":
                this.category = Message.ITEM_CHIP_MESSAGE.getMessage(); break;
            case "Candy":
                this.category = Message.ITEM_CANDY_MESSAGE.getMessage(); break;
            case "Drink":
                this.category = Message.ITEM_DRINK_MESSAGE.getMessage(); break;
            case "Gum":
                this.category = Message.ITEM_GUM_MESSAGE.getMessage(); break;
            default:
                this.category = Message.ITEM_CATEGORY_ERROR.getMessage(); break;
        }
    }

    enum Message {
        ITEM_CHIP_MESSAGE ("Crunch Crunch, Yum!"),
        ITEM_CANDY_MESSAGE ("Munch Munch, Yum!"),
        ITEM_DRINK_MESSAGE ("Glug Glug, Yum!"),
        ITEM_GUM_MESSAGE ("Chew Chew, Yum!"),
        ITEM_CATEGORY_ERROR ("\"Wrong sir, wrong! Under section 37B of the contract signed by him.\n" +
                "It states quite clearly that all offers shall become null and void if, \n" +
                "and you can read it for yourself in this photostatic copy.\"");

        private final String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }

    }

    public String dispenseItem(Money money) {
        if (price > money.getBalance()) {
            return Str.DISPENSE_ITEM_INSUFFICIENT_FUNDS;
        } else if (quantity <= 0) {
            return this.toString();
        } else {
            Log.log(" " + name + " " + location, money.getBalance(),
                    money.getBalance() - price);
            money.subtractMoney(price);
            quantity -= 1;
            enterWonkaContest(); // Checks for golden ticket
            return Str.DISPENSING + " " + name + ", " + df.format(price) + "\n" +
                    Str.CURRENT_BALANCE + money + "\n" +
                    category;
        }
    }

    private void enterWonkaContest() {
//        int score = (int) (Math.random() * 100);
        if (name.equals("Wonka Bar"))
            System.out.println(Str.ENTER_WONKA_CONTEST_MESSAGE);
    }

    @Override
    public String toString() { // displayItems() can handle different String lengths from here
        if (quantity > 0) {
            return " > " + location + " <   " + df.format(price) + " | qty: " + quantity + " | " + name;
        } else {
            return Str.ITEM_TO_STRING_SOLD_OUT;
        }
    }

}