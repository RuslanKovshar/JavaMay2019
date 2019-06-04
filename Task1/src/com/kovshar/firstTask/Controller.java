package com.kovshar.firstTask;

import java.util.Scanner;

public class Controller {

    public Model model;
    public View view;
    public final String FIRST_WORD = "Hello";
    public final String SECOND_WORD = "word!";

    /* Constructor*/
    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    /* The work method */
    public void processUser(){
        Scanner scanner = new Scanner(System.in);

        model.setSentence(inputWord(scanner,FIRST_WORD),inputWord(scanner,SECOND_WORD));

        view.printMessage(View.CORRECT_SENTENCE + model.getSentence());
    }

    /* The Utility method*/
    public String inputWord(Scanner scanner, String correctWord){
        view.printMessage(View.INPUT_WORD);
        String word = scanner.next();
        while (!word.equals(correctWord)){
            view.printMessage(View.INCORRECT_WORD + View.INPUT_WORD);
            word = scanner.next();
        }
        return word;
    }


}
