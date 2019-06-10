package com.kovshar.controller;

import com.kovshar.view.View;

import java.util.Scanner;

import static com.kovshar.view.TextConstants.*;

public class NoteBook implements RegularExpressions{
    private View view;
    private Scanner sc;

    private String firstName;
    private String secondName;
    private String nickName;

    public NoteBook(View view, Scanner sc){
        this.view = view;
        this.sc = sc;
    }

    public void inputValue(){
        ValueInputer valueInputer = new ValueInputer(sc, view);

        String msgFirstName = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? FIRST_NAME_UA : FIRST_NAME_EN;
        String msgSecondName = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? SECOND_NAME_UA : SECOND_NAME_EN;

        this.firstName = valueInputer.inputValueWithScanner(msgFirstName, FIRST_NAME );
        this.secondName = valueInputer.inputValueWithScanner(msgSecondName, SECOND_NAME);
        this.nickName = valueInputer.inputValueWithScanner(NICK_NAME,NICKNAME);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getNickName() {
        return nickName;
    }
}
