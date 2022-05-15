/*
 * Strings used throughout the application.
 */

package com.techelevator;

final class Str {
     /* File paths */
     public final static String LOG_FILE_PATH = "log.txt";
     public final static String GENERATE_LIST_ITEMS_FILEPATH = "vendingmachine.csv";

     /* Menu.java */
     public final static String DISPLAY_MENU_OPTIONS_PLEASE_CHOOSE = "Please choose an option >>> ";
     public final static String GET_CHOICE_FROM_USER_ERROR = " is not a valid option ***";
     public final static String PRINT_HEADER_WELCOME = "* Mr. Wonka's SCRUMDIDDLYUMPTIOUS Delights! *";

     /* Money.java */
     public final static String CURRENT_BALANCE = "CURRENT BALANCE: ";

     /* Inventory.java */
     public final static String SELECT_ITEM_USING_ID = "Please select an item using the letter and number location code:";
     public final static String SELECT_ITEM_INVALID_ITEM = "Invalid item location, please try again";
     public final static String DISPLAY_ITEM_HEADER = "LOCATION  PRICE   QTY      ITEM";

     /* Item.java */
//     public final static String ITEM_CHIP_MESSAGE = "Crunch Crunch, Yum!";
//     public final static String ITEM_CANDY_MESSAGE = "Munch Munch, Yum!";
//     public final static String ITEM_DRINK_MESSAGE = "Glug Glug, Yum!";
//     public final static String ITEM_GUM_MESSAGE = "Chew Chew, Yum!";
//     public final static String ITEM_CATEGORY_ERROR = "\"Wrong sir, wrong! Under section 37B of the contract signed by him.\n" +
//             "It states quite clearly that all offers shall become null and void if, \n" +
//             "and you can read it for yourself in this photostatic copy.\"";
     public final static String ENTER_WONKA_CONTEST_MESSAGE =
             "It was a very beautiful thing, this Golden Ticket, having been made, \n" +
             "so it seemed, from a sheet of pure gold hammered out almost to the thinness of paper. \n" +
             "On one side of it, printed by some clever method in jet-black letters, \n" +
             "was the invitation itself—from Mr. Wonka.";
     public final static String DISPENSE_ITEM_INSUFFICIENT_FUNDS = "Insufficient funds, please insert more money\n";
     public final static String DISPENSING = "Dispensing";
     public final static String ITEM_TO_STRING_SOLD_OUT = "   > *** SOLD OUT *** <";

     /* Log.java */
     public final static String LOG_FILE_NOT_FOUND = "log file not found";

     /* VendingMachine.java */
     public static final String RUN_FINAL_BALANCE = "FINAL BALANCE: ";
     public final static String RUN_MAIN_EXIT_GOODBYE = "Goodbye!";
}
