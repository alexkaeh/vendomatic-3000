/**
 * VEND-O-MATIC 9000
 *
 * A text based simulator of a cash-fed vending machine. It uses a multi-layered menu,
 * accessed by entering a number, to receive cash and dispense items and exact change in coins.
 *
 * Application Map
 * ***************
 *
 * MAIN MENU
 *   - Display Items
 *   - Purchase
 *      - Feed Money
 *      - Select Product
 *      - Finish Transaction
 *   - Exit
 *
 * @author Alex Kaehler, Ibi Coleman
 * @date 2022-04-11
 */

package com.techelevator;

import static java.lang.System.out;


public class VendingMachine {

    private final Menu menu;

    public VendingMachine(Menu menu) {
        this.menu = menu;
    }


    public void run() {
        Inventory inventory = new Inventory();
        Money money = new Money();
        String mainChoice, purchaseChoice, moneyChoice;


        Menu.printHeader(); // Edit in Str.java, banner width is dynamically formatted

        label:
        while (true) {
            mainChoice = (String) menu.getChoiceFromOptions(Menu.MAIN_OPTIONS);

            switch (mainChoice) {

                case Menu.MAIN_DISPLAY_ITEMS:
                    inventory.displayItems();
                    break;

                case Menu.MAIN_PURCHASE:
                    boolean returnToPurchase = true; // makes purchase menu loop, instead of kicking user up to main menu
                    while (returnToPurchase) {
                        purchaseChoice = (String) menu.getChoiceFromOptions(Menu.PURCHASE_OPTIONS);
                        switch (purchaseChoice) {

                            case Menu.PURCHASE_FEED_MONEY:
                                moneyChoice = (String) menu.getChoiceFromOptions(Menu.MONEY_OPTIONS);
                                switch (moneyChoice) {
                                    case Menu.MONEY_ADD_ONE:
                                        money.feedMoney(1); break;
                                    case Menu.MONEY_ADD_TWO:
                                        money.feedMoney(2); break;
                                    case Menu.MONEY_ADD_FIVE:
                                        money.feedMoney(5); break;
                                    case Menu.MONEY_ADD_TEN:
                                        money.feedMoney(10); break;
                                }
                                break;

                            case Menu.PURCHASE_SELECT_PRODUCT:
                                inventory.displayItems();
                                out.println(inventory.selectItem(money));
                                break;

                            case Menu.PURCHASE_FINISH_TRANSACTION:
                                out.println(money.makeChange());
                                out.println(Str.RUN_FINAL_BALANCE + money);
                                returnToPurchase = false;
                                break;
                        }
                    }
                    break;  // Breaks MAIN_PURCHASE switch

                case Menu.MAIN_EXIT:
                    out.println(Str.RUN_MAIN_EXIT_GOODBYE);
                    break label;
            }
        }
    }

    public static void main (String[]args){
        Menu menu = new Menu(System.in, System.out);
        VendingMachine cli = new VendingMachine(menu);
        cli.run();
    }

}