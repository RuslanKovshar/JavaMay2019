package com.kovshar.controller;

import com.kovshar.view.TextConstants;
import com.kovshar.view.View;

import java.util.Scanner;

public class Record implements RegularExpressions {
    private View view;
    private Scanner sc;

    private String firstName;
    private String secondName;
    private String nickName;
    private ValueInputer valueInputer;

    public Record(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
        this.valueInputer = new ValueInputer(sc,view);
    }

    public void inputValue() {
        String regFirstName = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? FIRST_NAME_UA : FIRST_NAME_EN;
        String regSecondName = (String.valueOf(View.bundle.getLocale()).equals("ua")) ? SECOND_NAME_UA : SECOND_NAME_EN;

        this.firstName = valueInputer.inputValueWithScanner(regFirstName, TextConstants.FIRST_NAME);
        this.secondName = valueInputer.inputValueWithScanner(regSecondName, TextConstants.SECOND_NAME);
        inputNickname();
        //this.nickName = valueInputer.inputValueWithScanner(RegularExpressions.NICKNAME, TextConstants.NICKNAME);
    }

    public void inputNickname(){
        this.nickName = valueInputer.inputValueWithScanner(RegularExpressions.NICKNAME, TextConstants.NICKNAME);
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