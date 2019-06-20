package com.company.model.simple.data.base;

public enum SmallCarTable {
    SMALL_CAR(30.99, 7, "BMW", "1:100");

    /*Every toys params*/
    private double price;
    private int ageCategory;

    /*Cars param*/
    private String model;

    /*Small car param*/
    private String scale;

    SmallCarTable(double price, int ageCategory, String model, String scale) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.model = model;
        this.scale = scale;
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

    public String getScale() {
        return scale;
    }
}
