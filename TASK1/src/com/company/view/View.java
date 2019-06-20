package com.company.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.company.view.TextConstants.INCORRECT_VALUE_MSG;

public class View {
    public String LINE = "============================";
    public String CHOOSE_LOCALE = "Choose locale";
    public String INCORRECT_LOCALE = "You can choose only 'en' or 'ua'";
    private static String BUNDLE_NAME = "messages";
    public static ResourceBundle bundle;

    public void setLocale(String locale) {
        bundle = ResourceBundle.getBundle(BUNDLE_NAME, new Locale(locale));
    }

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printMainMessage(String msg) {
        System.out.println(LINE + "\n" + msg + "\n" + LINE);
    }

    public void incorrectDataMessage() {
        System.out.println(bundle.getString(INCORRECT_VALUE_MSG));
    }

    public static String getBundleMessage(String key) {
        return bundle.getString(key);
    }
}
