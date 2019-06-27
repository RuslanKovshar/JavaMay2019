package com.company.model.simple.data.base;

public enum BallTable {
    /*Ball data*/
    BALL(29.99, 0, "Football", 4);

    /*Every toys params*/
    private double price;
    private int ageCategory;

    /*Balls params*/
    private int size;
    private String forWhatGame;

    /**
     * Creates a record of a simulation record in the database.
     * Constructor imitating Ball class
     *
     * @param price       price of a ball
     * @param ageCategory age category that allow kid to play with it
     * @param forWhatGame what game is the ball for
     * @param size        size of a ball
     */
    BallTable(double price, int ageCategory, String forWhatGame, int size) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.forWhatGame = forWhatGame;
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public int getAgeCategory() {
        return ageCategory;
    }

    public int getSize() {
        return size;
    }

    public String getForWhatGame() {
        return forWhatGame;
    }
}
