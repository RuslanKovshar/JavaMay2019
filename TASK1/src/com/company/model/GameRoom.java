package com.company.model;

import com.company.model.toys.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameRoom {
    private List<Toy> toys = new ArrayList<>();
    private int lowerBoundary = 0;
    private int upperBoundary = 3;

    public void setLowerBoundary(int lowerBoundary) {
        this.lowerBoundary = lowerBoundary;
    }

    public void setUpperBoundary(int upperBoundary) {
        this.upperBoundary = upperBoundary;
    }

    public void setToy(Toy toy) {
        toys.add(toy);
    }

    public List<Toy> getToys() {
        return toys;
    }

    /**
     * Sorts toys by price
     */
    public void sort() {
        toys.sort(Toy::compareTo);
    }


    /**
     * Finds toys for baby(age category between 0 and 3).
     *
     * @return ArrayList of toys for baby
     */
    public List<Toy> findToysForBaby() {
        return toys.stream()
                .filter(i -> i.getAgeCategory() >= lowerBoundary && i.getAgeCategory() <= upperBoundary)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Toy i : toys) {
            str.append(i.toString()).append("\n");
        }
        return new String(str);
    }
}