package com.company.model;

public enum SimpleDataBase {
    /*Dolls data*/
    FIRST_DOLL(19.99, 3, "Man", "Wood"),
    SECOND_DOLL(14.99, 5, "Barbie", "Plastic"),
    THIRD_DOLL(15.99, 6, "Soldier", "Wood"),
    FOURTH_DOLL(9.99, 3, "Bear", "Cloth"),

    /*Cubes data*/
    FIRST_CUBES(9.99, 0, 8, "Animals"),
    SECOND_CUBES(11.99, 3, 10, "Numbers"),
    THIRD_CUBES(15.99, 3, 26, "Alphabet"),
    FOURS_CUBES(8.99, 1, 20, "Things"),

    /*Balls data*/
    FIRST_BALL(9.99, 0, "Football", 4),
    SECOND_BALL(12.99, 0, "Basketball", 6),
    THIRD_BALL(7.99, 0, "Volleyball", 3),
    FOURTH_BALL(1.99, 0, "Tennis", 1);

    /*Every toys params*/
    private double price;
    private int ageCategory;

    /*Dolls params*/
    private String type;
    private String material;

    /*Cubes params*/
    private int count;
    private String drawing;

    /*Balls params*/
    private int size;
    private String forWhatGame;

    /**
     * Creates a record of a simulation record in the database.
     * Constructor imitating Doll class
     *
     * @param price       price of a doll
     * @param ageCategory age category that allow kid to play with it
     * @param type        type of a doll
     * @param material    material of which the doll is made
     */
    SimpleDataBase(double price, int ageCategory, String type, String material) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.type = type;
        this.material = material;
    }

    /**
     * Creates a record of a simulation record in the database.
     * Constructor imitating Cubes class
     *
     * @param price       price of a cubes
     * @param ageCategory age category that allow kid to play with it
     * @param count       number of cubes
     * @param drawing     what is shown on cubes
     */
    SimpleDataBase(double price, int ageCategory, int count, String drawing) {
        this.price = price;
        this.ageCategory = ageCategory;
        this.count = count;
        this.drawing = drawing;
    }

    /**
     * Creates a record of a simulation record in the database.
     * Constructor imitating Ball class
     *
     * @param price       price of a ball
     * @param ageCategory age category that allow kid to play with it
     * @param forWhatGame what game is the ball for
     * @param size        size of a ball
     */
    SimpleDataBase(double price, int ageCategory, String forWhatGame, int size) {
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

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public int getCount() {
        return count;
    }

    public String getDrawing() {
        return drawing;
    }

    public int getSize() {
        return size;
    }

    public String getForWhatGame() {
        return forWhatGame;
    }
}