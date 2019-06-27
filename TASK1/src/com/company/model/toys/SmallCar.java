package com.company.model.toys;

import com.company.view.View;

import static com.company.view.TextConstants.MODEL_MSG;
import static com.company.view.TextConstants.SCALE_MSG;

public class SmallCar extends Toy implements ToyCar {
    private String model;
    private String scale;

    public SmallCar(double price, int ageCategory, String model, String scale) {
        super(price, ageCategory);
        this.model = model;
        this.scale = scale;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return super.toString() + View.getBundleMessage(MODEL_MSG) + model + "\n" +
                View.getBundleMessage(SCALE_MSG) + scale + "\n";
    }

}
