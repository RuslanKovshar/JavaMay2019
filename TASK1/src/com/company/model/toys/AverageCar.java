package com.company.model.toys;

import com.company.view.View;

import static com.company.view.TextConstants.MAX_DISTANCE_MSG;
import static com.company.view.TextConstants.MODEL_MSG;

public class AverageCar extends Toy implements ToyCar {
    private String model;
    private int maxDistance;

    public AverageCar(double price, int ageCategory, String model, int maxDistance) {
        super(price, ageCategory);
        this.model = model;
        this.maxDistance = maxDistance;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return super.toString() + View.getBundleMessage(MODEL_MSG) + model + "\n" +
                View.getBundleMessage(MAX_DISTANCE_MSG) + maxDistance + "\n";
    }
}
