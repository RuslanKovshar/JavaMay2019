package com.company.model.simple.data.base;

public enum AverageCarTable {
    AVERAGE_CAR(50.99, 9, "Audi", 20);
    /*Every toys params*/
    private double price;
    private int ageCategory;

    /*Cars param*/
    private String model;

    /*Average car param*/
    private int maxDistance;

    AverageCarTable(double price, int ageCategory, String model, int maxDistance) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.model = model;
        this.maxDistance = maxDistance;
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

    public int getMaxDistance() {
        return maxDistance;
    }
}
