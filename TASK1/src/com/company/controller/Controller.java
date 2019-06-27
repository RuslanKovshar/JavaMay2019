package com.company.controller;

import com.company.model.GameRoom;
import com.company.view.View;

import java.util.Scanner;

import static com.company.view.TextConstants.*;

public class Controller {
    private GameRoom gameRoom;
    private View view;

    public Controller(GameRoom gameRoom, View view) {
        this.gameRoom = gameRoom;
        this.view = view;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        ValueInputer valueInputer = new ValueInputer(view,scanner);

        /*Set the locale for program*/
        view.setLocale(valueInputer.inputStringValue(view.CHOOSE_LOCALE));

        /*Create class for buying toys*/
        ToysCreator toysCreator = new ToysCreator(view, gameRoom, valueInputer,
                valueInputer.inputDoubleValue(View.getBundleMessage(INPUT_VALUE_MSG)));

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
        //gameRoom.setLowerBoundary(valueInputer.inputIntValue());
        //gameRoom.setUpperBoundary(valueInputer.inputIntValue());
        view.printMainMessage(View.getBundleMessage(TOYS_FOR_BABY_MSG));
        view.printList(gameRoom.findToysForBaby());
        scanner.close();
    }



}
