package com.company;

public class First {

    protected int value;

    First() {
        value = 3;
    }

    public void addFive() {
        value += 5;
        System.out.println("first ");
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
