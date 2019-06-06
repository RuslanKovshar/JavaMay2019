package com.company;

public class Second extends First {

    public Second(){
        value = 2;
    }

    @Override
    public void addFive () {
        value += 5;
        System.out.println("second ");
    }
}
