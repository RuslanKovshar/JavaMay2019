package com.company.model.toys;

import com.company.view.View;

import static com.company.view.TextConstants.MAX_SPEED_MSG;
import static com.company.view.TextConstants.MODEL_MSG;

public class BigCar extends Toy implements ToyCar {
    private String model;
    private int maxSpeed;

    public BigCar(double price, int ageCategory, String model, int maxSpeed) {
        super(price, ageCategory);
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return super.toString() + View.getBundleMessage(MODEL_MSG) + model + "\n" +
                View.getBundleMessage(MAX_SPEED_MSG) + maxSpeed + "\n";
    }
}
