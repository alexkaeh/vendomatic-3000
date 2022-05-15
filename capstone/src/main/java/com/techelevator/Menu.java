/*
 * Stores constant arrays of menu options, prints them, and gathers user input.
 *
 * Handles invalid inputs and menus of any length.
 */

package com.techelevator;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

    public static final String MAIN_DISPLAY_ITEMS = "Display Vending Machine Items";
    public static final String MAIN_PURCHASE = "Purchase";
    public static final String MAIN_EXIT = "Exit";
    public static final String[] MAIN_OPTIONS = {MAIN_DISPLAY_ITEMS, MAIN_PURCHASE, MAIN_EXIT};

    public static final String PURCHASE_FEED_MONEY = "Feed money";
    public static final String PURCHASE_SELECT_PRODUCT = "Select product";
    public static final String PURCHASE_FINISH_TRANSACTION = "Finish transaction";
    public static final String[] PURCHASE_OPTIONS = {PURCHASE_FEED_MONEY, PURCHASE_SELECT_PRODUCT, PURCHASE_FINISH_TRANSACTION};

    public static final String MONEY_ADD_ONE = "Add $1";
    public static final String MONEY_ADD_TWO = "Add $2";
    public static final String MONEY_ADD_FIVE = "Add $5";
    public static final String MONEY_ADD_TEN = "Add $10";
    public static final String[] MONEY_OPTIONS = {MONEY_ADD_ONE, MONEY_ADD_TWO, MONEY_ADD_FIVE, MONEY_ADD_TEN};

    private final PrintWriter out;
    private final Scanner in;

    public Menu(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.in = new Scanner(input);
    }


    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = in.nextLine();

        try {
            int selectedOption = Integer.parseInt(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }

        } catch (NumberFormatException e) {
            // eat the exception, an error message will be displayed below since choice will be null
        }

        if (choice == null) {
            out.println(System.lineSeparator() + "*** " + userInput + Str.GET_CHOICE_FROM_USER_ERROR + System.lineSeparator());
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        out.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            out.println(optionNum + ") " + options[i]);
        }
        out.print(System.lineSeparator() + Str.DISPLAY_MENU_OPTIONS_PLEASE_CHOOSE);
        out.flush();
    }

    public static void printHeader() {
        String banner = "*".repeat(Str.PRINT_HEADER_WELCOME.length());
        System.out.println(banner);
        System.out.println(Str.PRINT_HEADER_WELCOME);
        System.out.println(banner + "\n");
    }
}
