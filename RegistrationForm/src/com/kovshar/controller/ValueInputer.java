package com.kovshar.controller;

import com.kovshar.view.View;

import java.util.Scanner;

public class ValueInputer {
    private Scanner sc;
    private View view;

    ValueInputer(Scanner sc, View view){
        this.sc = sc;
        this.view = view;
    }

    /**
     * Проверяет правильность введенного сравнивая с регулярным выражением
     * @param regex     Регулярное выражение
     * @param msg       Сообщения для просьбы ввести значение
     * @return value    Коректное значение
     */
    public String inputValueWhithScanner(String regex, String msg){
        String value;
        do {
            view.printMessage(msg);
            value = sc.next();
        }while (!value.matches(regex));
        return value;
    }
}
