package com.kovshar.controller;

import com.kovshar.model.Model;
import com.kovshar.model.NotUniqueNicknameException;
import com.kovshar.model.NoteBook;
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
        Record record = new Record(view, scanner);
        NoteBook noteBook = addRecord(record);
        noteBook.showRecord();
    }

    public NoteBook addRecord(Record record) {
        NoteBook noteBook = null;
        while (true) {
            record.inputValue();
            try {
                noteBook = new NoteBook(record, view);
                break;
            } catch (NotUniqueNicknameException ex) {
                ex.printStackTrace();
            }
        }
        return noteBook;
    }
}