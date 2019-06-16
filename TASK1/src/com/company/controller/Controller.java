package com.company.controller;

import com.company.model.*;

import static com.company.view.TextConstants.*;
import static com.company.model.SimpleDataBase.*;
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
        view.printsMessage(View.bundle.getString(HELLO));
        Scanner scanner = new Scanner(System.in);
        inputValue(scanner);
        System.out.println(FIRST_BALL.getCount());
        scanner.close();
    }

    public double inputValue(Scanner sc) {
        view.printsMessage(View.getBundleMessage(INPUT_VALUE_MSG));
        //TODO: Если не дабл, то повторить в цыкле
        return sc.nextDouble();
    }
}
