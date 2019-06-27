package com.company.view;

import com.company.model.toys.Toy;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.company.view.TextConstants.EMPTY_MSG;
import static com.company.view.TextConstants.INCORRECT_VALUE_MSG;

public class View {
    private static String BUNDLE_NAME = "messages";
    private static ResourceBundle bundle;

    private String LINE = "============================";
    public String CHOOSE_LOCALE = "Choose locale";
    public String INCORRECT_LOCALE = "You can choose only 'en' or 'ua'";
    public String UA = "ua";
    public String EN = "en";

    public void setLocale(String locale) {
        bundle = ResourceBundle.getBundle(BUNDLE_NAME, new Locale(locale));
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printMainMessage(String msg) {
        System.out.println(LINE + "\n" + msg + "\n" + LINE);
    }

    public void printList(List<Toy> toys) {
        if (toys.isEmpty()) {
            printMessage(View.getBundleMessage(EMPTY_MSG));
        } else {
            toys.forEach(System.out::println);
        }
    }

    public void incorrectDataMessage() {
        System.out.println(bundle.getString(INCORRECT_VALUE_MSG));
    }

    public static String getBundleMessage(String key) {
        return bundle.getString(key);
    }
}
