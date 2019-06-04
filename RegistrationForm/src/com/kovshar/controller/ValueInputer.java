package com.kovshar.controller;

import com.kovshar.view.View;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueInputer {
    private Scanner sc;
    private View view;

    ValueInputer(Scanner sc, View view){
        this.sc = sc;
        this.view = view;
    }

    public String inputValueWhithScanner(String regex){
        String value;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;
        do {
            view.printMessage(View.INPUT_FIRST_NAME);
            value = sc.next();
            matcher = pattern.matcher(value);
        }while (!matcher.matches());
        return value;
    }
}
