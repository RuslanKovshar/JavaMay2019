package com.company.controller;

import com.company.view.View;

import java.util.Scanner;

class ValueInputer {
    private Scanner scanner;
    private View view;

    ValueInputer(View view, Scanner scanner) {
        this.scanner = scanner;
        this.view = view;
    }

    /**
     * Enters value of amount of money.
     *
     * @param message the message that prints what you need to input
     * @return value of amount of money
     */
    double inputDoubleValue(String message) {
        view.printMessage(message);
        while (!scanner.hasNextDouble()) {
            view.incorrectDataMessage();
            scanner.next();
        }
        return scanner.nextDouble();
    }

    /**
     * Enters value of locale param.
     *
     * @param message the message that prints what you need to input
     * @return value of locale (en or ua only)
     */
    String inputStringValue(String message) {
        view.printMessage(message);
        String value = scanner.next();
        while (!(value.equals(view.EN) || value.equals(view.UA))) {
            view.printMessage(view.INCORRECT_LOCALE);
            value = scanner.next();
        }
        return value;
    }

    /**
     * Enters int value for choosing toy.
     *
     * @param message the message that prints what you need to input
     * @return int value
     */
    int inputIntValue(String message) {
        view.printMessage(View.getBundleMessage(message));
        while (!scanner.hasNextInt()) {
            view.incorrectDataMessage();
            scanner.next();
        }
        return scanner.nextInt();
    }
}
