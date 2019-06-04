package com.kovshar.model;

public class Model {
    private String firstName;
    private String secondName;
    private String nickName;

    public String getSentence(){
        StringBuilder tempStr = new StringBuilder();
        tempStr.append(firstName).append(secondName).append(nickName);
        return tempStr.toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getFirstName(){
        return firstName;
    }
}
