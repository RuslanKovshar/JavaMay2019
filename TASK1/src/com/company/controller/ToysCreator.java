package com.company.controller;

import com.company.model.*;
import com.company.view.View;

import java.util.Scanner;

import static com.company.model.SimpleDataBase.*;
import static com.company.view.TextConstants.*;

public class ToysCreator {
    private GameRoom gameRoom;
    private View view;
    private Scanner scanner;
    private Toy toy;
    private double amountOfMoney;

    ToysCreator(View view, Scanner scanner, GameRoom gameRoom, double amountOfMoney) {
        this.view = view;
        this.scanner = scanner;
        this.amountOfMoney = amountOfMoney;
        this.gameRoom = gameRoom;
    }

    public void chooseToy() {
        boolean choose = true;
        while (amountOfMoney > 0.0 && choose) {
            view.printMessage(View.getBundleMessage(AMOUNT_OF_MONEY_MSG) + amountOfMoney);
            int number = inputValue(CHOOSE_TOY_MSG);
            switch (number) {
                case 1:
                    buyDoll();
                    break;
                case 2:
                    buyBall();
                    break;
                case 3:
                    buyCubes();
                    break;
                case 0:
                    choose = false;
                    break;
                default:
                    view.incorrectDataMessage();
            }
        }
    }

    private boolean checkPrice(double price) {
        return price <= amountOfMoney;
    }

    private void addToy() {
        if (checkPrice(toy.getPrice())) {
            amountOfMoney -= toy.getPrice();
            gameRoom.setToy(toy);
        } else {
            view.printMessage(View.getBundleMessage(LOW_MONEY_MSG));
        }
    }

    public int inputValue(String msg) {
        view.printMessage(View.getBundleMessage(msg));
        while (!scanner.hasNextInt()) {
            view.printMessage(View.getBundleMessage(INCORRECT_VALUE_MSG));
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void buyDoll() {
        boolean runCycle = true;
        while (runCycle) {
            int number = inputValue(CHOOSE_DOLL_MSG);
            switch (number) {
                case 1:
                    toy = new Doll(FIRST_DOLL.getPrice(),
                            FIRST_DOLL.getAgeCategory(),
                            FIRST_DOLL.getType(),
                            FIRST_DOLL.getMaterial());
                    runCycle = false;
                    break;
                case 2:
                    toy = new Doll(SECOND_DOLL.getPrice(),
                            SECOND_DOLL.getAgeCategory(),
                            SECOND_DOLL.getType(),
                            SECOND_DOLL.getMaterial());
                    runCycle = false;
                    break;
                case 3:
                    toy = new Doll(THIRD_DOLL.getPrice(),
                            THIRD_DOLL.getAgeCategory(),
                            THIRD_DOLL.getType(),
                            THIRD_DOLL.getMaterial());
                    runCycle = false;
                    break;
                case 4:
                    toy = new Doll(FOURTH_DOLL.getPrice(),
                            FOURTH_DOLL.getAgeCategory(),
                            FOURTH_DOLL.getType(),
                            FOURTH_DOLL.getMaterial());
                    runCycle = false;
                    break;
                default:
                    view.incorrectDataMessage();
            }
        }
        addToy();
    }

    private void buyBall() {
        boolean runCycle = true;
        while (runCycle) {
            int number = inputValue(CHOOSE_BALL_MSG);
            switch (number) {
                case 1:
                    toy = new Ball(FIRST_BALL.getPrice(),
                            FIRST_BALL.getAgeCategory(),
                            FIRST_BALL.getSize(),
                            FIRST_BALL.getForWhatGame());
                    runCycle = false;
                    break;
                case 2:
                    toy = new Ball(SECOND_BALL.getPrice(),
                            SECOND_BALL.getAgeCategory(),
                            SECOND_BALL.getSize(),
                            SECOND_BALL.getForWhatGame());
                    runCycle = false;
                    break;
                case 3:
                    toy = new Ball(THIRD_BALL.getPrice(),
                            THIRD_BALL.getAgeCategory(),
                            THIRD_BALL.getSize(),
                            THIRD_BALL.getForWhatGame());
                    runCycle = false;
                    break;
                case 4:
                    toy = new Ball(FOURTH_BALL.getPrice(),
                            FOURTH_BALL.getAgeCategory(),
                            FOURTH_BALL.getSize(),
                            FOURTH_BALL.getForWhatGame());
                    runCycle = false;
                    break;
                default:
                    view.incorrectDataMessage();
            }
        }
        addToy();
    }

    private void buyCubes() {
        boolean runCycle = true;
        while (runCycle) {
            int number = inputValue(CHOOSE_CUBES_MSG);
            switch (number) {
                case 1:
                    toy = new Cubes(FIRST_CUBES.getPrice(),
                            FIRST_CUBES.getAgeCategory(),
                            FIRST_CUBES.getCount(),
                            FIRST_CUBES.getDrawing());
                    runCycle = false;
                    break;
                case 2:
                    toy = new Cubes(SECOND_CUBES.getPrice(),
                            SECOND_CUBES.getAgeCategory(),
                            SECOND_CUBES.getCount(),
                            SECOND_CUBES.getDrawing());
                    runCycle = false;
                    break;
                case 3:
                    toy = new Cubes(THIRD_CUBES.getPrice(),
                            THIRD_CUBES.getAgeCategory(),
                            THIRD_CUBES.getCount(),
                            THIRD_CUBES.getDrawing());
                    runCycle = false;
                    break;
                case 4:
                    toy = new Cubes(FOURS_CUBES.getPrice(),
                            FOURS_CUBES.getAgeCategory(),
                            FOURS_CUBES.getCount(),
                            FOURS_CUBES.getDrawing());
                    runCycle = false;
                    break;
                default:
                    view.incorrectDataMessage();
            }
        }
        addToy();
    }
}