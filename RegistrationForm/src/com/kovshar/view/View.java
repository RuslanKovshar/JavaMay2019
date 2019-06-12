package com.kovshar.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View implements TextConstants {
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME, new Locale("ua", "UA"));
    //new Locale("en"));

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public String concat(String... message) {
        StringBuilder concatString = new StringBuilder();
        for (String str : message) {
            concatString.append(str);
        }
        return new String(concatString);
    }

    public void printInputMessage(String msg) {
        printMessage(concat(
                bundle.getString(INPUT_DATA),
                bundle.getString(msg)));
    }

    public void printWrongMessage(String msg) {
        printMessage(bundle.getString(WRONG_DATA));
        printInputMessage(msg);
    }
}