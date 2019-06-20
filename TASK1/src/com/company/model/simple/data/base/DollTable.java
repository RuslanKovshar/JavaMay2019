package com.company.model.simple.data.base;

public enum DollTable {
    /*Doll data*/
    DOLL(19.99, 3, "Man", "Wood");

    /*Every toys params*/
    private double price;
    private int ageCategory;

    /*Dolls params*/
    private String type;
    private String material;

    /**
     * Creates a record of a simulation record in the database.
     * Constructor imitating Doll class
     *
     * @param price       price of a doll
     * @param ageCategory age category that allow kid to play with it
     * @param type        type of a doll
     * @param material    material of which the doll is made
     */
    DollTable(double price, int ageCategory, String type, String material) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.type = type;
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }
}
