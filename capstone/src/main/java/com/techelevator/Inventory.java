/*
 * Contains a list of all items in the vending machine and an item lookup map.
 *
 * displayItems() arranges items in two columns, width can be adjusted with columnWidth
 */

package com.techelevator;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.out;

public class Inventory {

    private final List<Item> items = new ArrayList<>();
    private final Map<String, Item> itemLocations = new HashMap<>(); // Map keys are item locations (e.g. A1, C4)


    public Inventory() {
        generateList();
        generateMap();
    }


    public String selectItem(Money money) {
        Scanner sc = new Scanner(System.in);
        out.println(Str.CURRENT_BALANCE + money);
        out.println(Str.SELECT_ITEM_USING_ID);
        String itemChoice = sc.next();
        Item item = itemLocations.get(itemChoice.toUpperCase()); // Lookup is case-insensitive (a1 vs A1)

        if (item != null) {
            return (item.dispenseItem(money));
        } else {
            return (Str.SELECT_ITEM_INVALID_ITEM);
        }
    }

    public void displayItems() {

        String header = Str.DISPLAY_ITEM_HEADER; // value is "LOCATION  PRICE   QTY      ITEM"
        int columnSpace = 3;

        // adds length of the longest string to columnSpace to get total desired length of first column
        int firstColumnWidth = getLongestItemStringLength(items) + columnSpace;

        // "formatter looks like "%-50s %s\n", left justifies and adds whitespace to length 50
        out.printf("%-" + firstColumnWidth + "s %s\n", header, header);

        // Prints every other entry for first column
        for (int i = 0; i < items.size(); i+=2) {

            // Same formatting as above, idk why it needs the +1 but it does
            out.printf("%-" + (firstColumnWidth + 1) + "s", items.get(i));

            // Avoid going out of array bounds
            if (i + 1 < items.size()) {

                // Prints every other entry + 1 for second column
                out.print(items.get(i + 1));
            }
            out.println(); // New line after each row
        }
    }

    /* PRIVATE METHODS */

    private int getLongestItemStringLength(@NotNull List<Item> items) {
        int longest = 0;
        for (Item item : items) {
            if (longest < item.toString().length()) {
                longest = item.toString().length();
            }
        }
        return longest;
    }

    private void generateList() {
        String filePath = Str.GENERATE_LIST_ITEMS_FILEPATH;
        // File contains list of items, with values per item separated by '|'
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] entries = line.split("\\|");
                items.add(new Item(entries[0], entries[1], Double.parseDouble(entries[2]), entries[3], 5));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void generateMap() {
        for (Item item : items) { //Item lookup table
            itemLocations.put(item.getLocation(), item);
        }
    }

}


