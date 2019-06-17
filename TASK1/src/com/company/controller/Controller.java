package com.company.controller;

import com.company.model.*;

import static com.company.view.TextConstants.*;

import com.company.view.View;

import java.util.Scanner;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void process() {
        Scanner scanner = new Scanner(System.in);
        GameRoom gameRoom = new GameRoom(view);
        ToysCreator toysCreator = new ToysCreator(view, scanner, gameRoom, inputValue(scanner));

        toysCreator.chooseToy();

        view.printMainMessage(View.getBundleMessage(YOUR_TOYS_MSG));
        view.printMessage(gameRoom.toString());

        view.printMainMessage(View.getBundleMessage(SORTING_MSG));
        gameRoom.sort();
        view.printMessage(gameRoom.toString());

        view.printMainMessage(View.getBundleMessage(TOYS_FOR_BABY_MSG));
        gameRoom.showToysForBaby();
        scanner.close();
    }

    public double inputValue(Scanner sc) {
        view.printMessage(View.getBundleMessage(INPUT_VALUE_MSG));
        while (!sc.hasNextDouble()) {
            view.printMessage(View.getBundleMessage(INCORRECT_VALUE_MSG));
            sc.next();
        }
        return sc.nextDouble();
    }
}
