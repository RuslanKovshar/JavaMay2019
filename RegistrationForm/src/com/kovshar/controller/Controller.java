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

    public void process(){
        Scanner scanner = new Scanner(System.in);
        ValueInputer valueInputer = new ValueInputer(scanner, view);

        model.setFirstName(valueInputer.inputValueWhithScanner(firstName));
        System.out.println(model.getFirstName());

    }


}