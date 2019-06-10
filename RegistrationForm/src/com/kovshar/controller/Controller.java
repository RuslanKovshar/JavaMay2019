package com.kovshar.controller;

import com.kovshar.model.Model;
import com.kovshar.view.View;

import java.util.Scanner;

public class Controller implements RegularExpressions {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Запускает процес ввода необходимых значений, проверяет их, формирует строку(передает управление в модель)
     * и отображает на экран(передает управление на View)
     */
    public void process() {
        Scanner scanner = new Scanner(System.in);
        NoteBook noteBook = new NoteBook(view,scanner);
        noteBook.inputValue();
        model.setFirstName(noteBook.getFirstName());
        model.setSecondName(noteBook.getSecondName());
        model.setNickName(noteBook.getNickName());
    }
}