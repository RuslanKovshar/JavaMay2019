package com.kovshar.model;

import com.kovshar.controller.Record;
import com.kovshar.view.TextConstants;
import com.kovshar.view.View;

public class NoteBook {
    private String firstName;
    private String secondName;
    private String nickName;
    private View view;

    public NoteBook(Record record, View view) throws NotUniqueNicknameException {
        if (SimpleDataBase.checkNickname(record.getNickName())) {
            throw new NotUniqueNicknameException(record.getNickName());
        } else {
            this.firstName = record.getFirstName();
            this.secondName = record.getSecondName();
            this.nickName = record.getNickName();
            this.view = view;
        }
    }

    public void showRecord() {
        view.printMessage(View.bundle.getString(TextConstants.YOUR_NAME) + firstName);
        view.printMessage(View.bundle.getString(TextConstants.YOUR_SECOND_NAME) + secondName);
        view.printMessage(View.bundle.getString(TextConstants.YOUR_NICKNAME) + nickName);
    }
}