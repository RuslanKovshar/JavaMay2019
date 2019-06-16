package com.company.model;

import com.company.view.View;

import static com.company.view.TextConstants.COUNT_MSG;
import static com.company.view.TextConstants.DRAWING_MSG;

public class Cubes extends Toy {
    private int count;
    private String drawing;

    public Cubes(double price, int ageCategory, int count, String drawing) {
        super(price, ageCategory);
        this.count = count;
        this.drawing = drawing;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDrawing() {
        return drawing;
    }

    public void setDrawing(String drawing) {
        this.drawing = drawing;
    }

    @Override
    public String toString(){
        return super.toString() + View.getBundleMessage(COUNT_MSG) + count + "\n" +
                View.getBundleMessage(DRAWING_MSG) + drawing + "\n";
    }
}