package com.company.model;

import com.company.view.View;

import static com.company.view.TextConstants.SIZE_MSG;
import static com.company.view.TextConstants.FOR_WHAT_GAME_MSG;

public class Ball extends Toy {
    private int size;
    private String forWhatGame;

    public Ball(double price, int ageCategory, int size, String forWhatGame) {
        super(price, ageCategory);
        this.size = size;
        this.forWhatGame = forWhatGame;
    }

    public int getSize() {
        return size;
    }

    public String getForWhatGame() {
        return forWhatGame;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setForWhatGame(String forWhatGame) {
        this.forWhatGame = forWhatGame;
    }

    @Override
    public String toString(){
        return super.toString() + View.getBundleMessage(SIZE_MSG) + size + "\n" +
                View.getBundleMessage(FOR_WHAT_GAME_MSG) + forWhatGame + "\n";
    }
}