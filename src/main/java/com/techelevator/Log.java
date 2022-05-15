package com.techelevator;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

// https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html

final class Log {

    // date and time
    private static String getCurrentTime() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
        Date now = new Date();
        return sdfDate.format(now);
    }

    public static void log(String event, double startBalance, double endBalance) {
        File f = new File(Str.LOG_FILE_PATH);

        try (PrintWriter w = new PrintWriter(new FileWriter(f, true))) {
            w.println(getCurrentTime() + event + " " + Item.df.format(startBalance) +
                    " " + Item.df.format(endBalance));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}