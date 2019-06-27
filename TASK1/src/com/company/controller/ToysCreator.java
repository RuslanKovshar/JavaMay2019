package com.company.controller;

import com.company.model.GameRoom;
import com.company.model.toys.*;
import com.company.view.TextConstants;
import com.company.view.View;

import static com.company.model.simple.data.base.AverageCarTable.AVERAGE_CAR;
import static com.company.model.simple.data.base.BallTable.BALL;
import static com.company.model.simple.data.base.BigCarTable.BIG_CAR;
import static com.company.model.simple.data.base.CubesTable.CUBES;
import static com.company.model.simple.data.base.DollTable.DOLL;
import static com.company.model.simple.data.base.SmallCarTable.SMALL_CAR;
import static com.company.view.TextConstants.AMOUNT_OF_MONEY_MSG;
import static com.company.view.TextConstants.LOW_MONEY_MSG;

class ToysCreator {
    private GameRoom gameRoom;
    private View view;
    private ValueInputer valueInputer;
    private Toy toy;
    private double amountOfMoney;

    ToysCreator(View view, GameRoom gameRoom,ValueInputer valueInputer, double amountOfMoney) {
        this.view = view;
        this.valueInputer = valueInputer;
        this.amountOfMoney = amountOfMoney;
        this.gameRoom = gameRoom;
    }

    /**
     * Allows to choose the toy to buy.
     */
    void chooseToy() {
        boolean choose = true;
        while (amountOfMoney > 0.0 && choose) {
            view.printMessage(View.getBundleMessage(AMOUNT_OF_MONEY_MSG) + amountOfMoney);
            int number = valueInputer.inputIntValue(TextConstants.CHOOSE_TOY_MSG);
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
                case 4:
                    buySmallCar();
                    break;
                case 5:
                    buyAverageCar();
                    break;
                case 6:
                    buyBigCar();
                    break;
                case 0:
                    choose = false;
                    break;
                default:
                    view.incorrectDataMessage();
            }
        }
    }

    /**
     * Compares the price of toy and the amount of money.
     *
     * @param price price of toy
     * @return true if we can buy toy
     */
    private boolean checkPrice(double price) {
        return price <= amountOfMoney;
    }


    /**
     * Adds toy to list of toys in game room.
     */
    private void addToy() {
        if (checkPrice(toy.getPrice())) {
            amountOfMoney -= toy.getPrice();
            gameRoom.setToy(toy);
        } else {
            view.printMessage(View.getBundleMessage(LOW_MONEY_MSG));
        }
    }


    /**
     * Creates a doll, and adds it to list.
     */
    private void buyDoll() {
        toy = new Doll(DOLL.getPrice(),
                DOLL.getAgeCategory(),
                DOLL.getType(),
                DOLL.getMaterial());
        addToy();
    }

    /**
     * Creates a ball, and adds it to list.
     */
    private void buyBall() {
        toy = new Ball(BALL.getPrice(),
                BALL.getAgeCategory(),
                BALL.getSize(),
                BALL.getForWhatGame());
        addToy();
    }

    /**
     * Creates a cubes, and adds it to list.
     */
    private void buyCubes() {
        toy = new Cubes(CUBES.getPrice(),
                CUBES.getAgeCategory(),
                CUBES.getCount(),
                CUBES.getDrawing());
        addToy();
    }

    /**
     * Creates a small car, and adds it to list.
     */
    private void buySmallCar() {
        toy = new SmallCar(SMALL_CAR.getPrice(),
                SMALL_CAR.getAgeCategory(),
                SMALL_CAR.getModel(),
                SMALL_CAR.getScale());
        addToy();
    }

    /**
     * Creates a average car, and adds it to list.
     */
    private void buyAverageCar() {
        toy = new AverageCar(AVERAGE_CAR.getPrice(),
                AVERAGE_CAR.getAgeCategory(),
                AVERAGE_CAR.getModel(),
                AVERAGE_CAR.getMaxDistance());
        addToy();
    }

    /**
     * Creates a big car, and adds it to list.
     */
    private void buyBigCar() {
        toy = new BigCar(BIG_CAR.getPrice(),
                BIG_CAR.getAgeCategory(),
                BIG_CAR.getModel(),
                BIG_CAR.getMaxSpeed());
        addToy();
    }
}