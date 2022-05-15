/*
 * Deals with methods relating to money. Contains and tracks a single field 'balance',
 * which is initialized to 0 when the program starts.
 *
 * Balance can be printed using an implicit toString call on the object.
 */

package com.techelevator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor // initializing balance with a non-zero amount is only used for JUnit testing
public class Money {

    private double balance = 0;


    public String makeChange() {
        int change = (int) (balance *= 100); // Times 100 and cast to int eliminates weird rounding bug
        int quarters = 0, dimes = 0, nickles = 0;

        while (change >= 25) {
            change -= 25;
            quarters++;
        }
        while (change >= 10) {
            change -= 10;
            dimes++;
        }
        while (change >= 5) {
            change -= 5;
            nickles++;
        }
        balance /= 100;
        Log.log(" GIVE CHANGE", balance, 0.0);
        balance = 0;
        return "YOUR CHANGE\n" +
                "Quarters: " + quarters + "\n" +
                "Dimes: " + dimes + "\n" +
                "Nickles: " + nickles + "\n";
    }

    public void feedMoney(int dollars) {
        Log.log(" FEED MONEY", balance, balance + dollars);
        balance += dollars;
        System.out.println("$" + dollars + " bill added.");
        System.out.println(Str.CURRENT_BALANCE + this);

    }

    public void subtractMoney(double amount) {
        balance -= amount;
    }

    @Override
    public String toString() {
        return Item.df.format(balance); //df.format double to "$0.00"

    }

}
