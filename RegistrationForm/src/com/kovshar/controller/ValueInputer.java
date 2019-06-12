package com.kovshar.controller;

import com.kovshar.view.View;

import java.util.Scanner;

public class ValueInputer {
    private Scanner sc;
    private View view;

    ValueInputer(Scanner sc, View view) {
        this.sc = sc;
        this.view = view;
    }

    /**
     * Проверяет правильность введенного сравнивая с регулярным выражением
     *
     * @param regex Регулярное выражение
     * @param msg   Сообщения для просьбы ввести значение
     * @return value    Коректное значение
     */
    public String inputValueWithScanner(String regex, String msg) {
        String value;
        view.printInputMessage(msg);
        while (!(sc.hasNext() && (value = sc.next()).matches(regex))) {
            view.printWrongMessage(msg);
        }
        return value;
    }
}
