package com.kovshar.controller;

import com.kovshar.model.Model;
import com.kovshar.view.View;

import java.util.Scanner;

public class Controller implements RegularExpressions{
    private Model model;
    private View view;

    public Controller(Model model,View view){
        this.model = model;
        this.view = view;
    }

    /**
     * Запускает процес ввода необходимых значений, проверяет их, формирует строку(передает управление в модель)
     * и отображает на экран(передает управление на View)
     */
    public void process(){
        Scanner scanner = new Scanner(System.in);
        ValueInputer valueInputer = new ValueInputer(scanner, view);

        model.setFirstName(valueInputer.inputValueWhithScanner(firstName,View.INPUT_FIRST_NAME));
        model.setSecondName(valueInputer.inputValueWhithScanner(secondName, View.INPUT_SECOND_NAME));
        model.setNickName(valueInputer.inputValueWhithScanner(nickName,View.INPUT_NICKNAME));
        view.printMessage(View.NAME_VALUE + model.getFirstName() + View.ENDL +
                View.SECOND_NAME_VALUE + model.getSecondName() + View.ENDL +
                View.NICKNAME + model.getNickName());
    }
}