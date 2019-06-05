package com.kovshar.firstTask;

public class Model {

    private String sentence;

    public void setSentence(String firstWord, String secondWord){
        sentence = firstWord + " " + secondWord;
    }

    public String getSentence(){
        return sentence;
    }
}
