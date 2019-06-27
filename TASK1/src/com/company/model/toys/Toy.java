package com.company.model.toys;

import com.company.view.View;

import static com.company.view.TextConstants.PRICE_MSG;
import static com.company.view.TextConstants.AGE_CATEGORY_MSG;

public abstract class Toy implements Comparable<Toy> {
    protected double price;
    protected int ageCategory;

    Toy(double price, int ageCategory) {
        this.price = price;
        this.ageCategory = ageCategory;
    }

    public double getPrice() {
        return price;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return View.getBundleMessage(PRICE_MSG) + price + "\n" +
                View.getBundleMessage(AGE_CATEGORY_MSG) + ageCategory + "\n";
    }

    @Override
    public int compareTo(Toy toy) {
        return Double.compare(this.price, toy.getPrice());
    }
}