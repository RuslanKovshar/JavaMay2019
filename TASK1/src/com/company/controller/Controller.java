package com.company.controller;

import com.company.model.*;

import static com.company.view.TextConstants.*;

import com.company.view.View;

import java.util.Scanner;

public class Controller {
    private GameRoom gameRoom;
    private View view;

    public Controller(GameRoom gameRoom, View view) {
        this.gameRoom = gameRoom;
        this.view = view;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);

        /*Set the locale for program*/
        view.setLocale(inputStringValue(scanner));

        /*Create class for buying toys*/
        ToysCreator toysCreator = new ToysCreator(view, gameRoom, scanner, inputDoubleValue(scanner));

        /*Buy toys*/
        toysCreator.chooseToy();

        /*Show all purchased toys*/
        view.printMainMessage(View.getBundleMessage(YOUR_TOYS_MSG));
        view.printMessage(gameRoom.toString());

        /*Sorting toys by price*/
        view.printMainMessage(View.getBundleMessage(SORTING_MSG));
        gameRoom.sort();
        view.printMessage(gameRoom.toString());

        /*Show toys for baby*/
        view.printMainMessage(View.getBundleMessage(TOYS_FOR_BABY_MSG));
        gameRoom.showToysForBaby();
        scanner.close();
    }


    /**
     * Enters value of amount of money.
     *
     * @param sc object of scanner class
     * @return value of amount of money
     */
    private double inputDoubleValue(Scanner sc) {
        view.printMessage(View.getBundleMessage(INPUT_VALUE_MSG));
        while (!sc.hasNextDouble()) {
            view.printMessage(View.getBundleMessage(INCORRECT_VALUE_MSG));
            sc.next();
        }
        return sc.nextDouble();
    }

    /**
     * Enters value of locale param.
     *
     * @param sc object of scanner class
     * @return value of locale (en or ua only)
     */
    private String inputStringValue(Scanner sc) {
        view.printMessage(view.CHOOSE_LOCALE);
        String value = sc.next();
        while (!(value.equals("en") || value.equals("ua"))) {
            view.printMessage(view.INCORRECT_LOCALE);
            value = sc.next();
        }
        return value;
    }
}
