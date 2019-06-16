package com.company.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    private static String BUNDLE_NAME = "messages";
    public final static ResourceBundle bundle = ResourceBundle.getBundle(BUNDLE_NAME,new Locale("ua"));

    public void printsMessage(String msg){
        System.out.println(msg);
    }

    public static String getBundleMessage(String key) {
        return bundle.getString(key);
    }
}
