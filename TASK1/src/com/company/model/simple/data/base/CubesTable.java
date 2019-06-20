package com.company.model.simple.data.base;

public enum CubesTable {
    /*Cube data*/
    CUBES(9.99, 0, 8, "Animals");

    /*Every toys params*/
    private double price;
    private int ageCategory;

    /*Cubes params*/
    private int count;
    private String drawing;

    /**
     * Creates a record of a simulation record in the database.
     * Constructor imitating Cubes class
     *
     * @param price       price of a cubes
     * @param ageCategory age category that allow kid to play with it
     * @param count       number of cubes
     * @param drawing     what is shown on cubes
     */
    CubesTable(double price, int ageCategory, int count, String drawing) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.count = count;
        this.drawing = drawing;
    }

    public double getPrice() {
        return price;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public int getCount() {
        return count;
    }

    public String getDrawing() {
        return drawing;
    }
}
