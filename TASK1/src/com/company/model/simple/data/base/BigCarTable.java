package com.company.model.simple.data.base;

public enum BigCarTable {
    BIG_CAR(99.99, 6, "Mercedes", 10);

    /*Every toys params*/
    private double price;
    private int ageCategory;

    /*Cars param*/
    private String model;

    /*Big car param*/
    private int maxSpeed;

    BigCarTable(double price, int ageCategory, String model, int maxSpeed) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public double getPrice() {
        return price;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
