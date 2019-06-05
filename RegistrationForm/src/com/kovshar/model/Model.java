package com.kovshar.model;

public class Model {
    private String firstName;
    private String secondName;
    private String nickName;

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

    public String getSecondName(){ return secondName; }

    public String getNickName(){ return nickName; }
}
