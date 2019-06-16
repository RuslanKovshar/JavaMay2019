package com.company.model;

import com.company.view.View;

import static com.company.view.TextConstants.PRICE_MSG;
import static com.company.view.TextConstants.AGE_CATEGORY_MSG;

public abstract class Toy {
    protected double price;
    protected int ageCategory;

    Toy(double price, int ageCategory) {
        this.price = price;
        this.ageCategory = ageCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return View.getBundleMessage(PRICE_MSG) + price + "\n" +
               View.getBundleMessage(AGE_CATEGORY_MSG) + ageCategory + "\n";
    }
}