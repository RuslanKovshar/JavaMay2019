package com.company.model;

import com.company.model.toys.Toy;
import com.company.view.View;

import java.util.ArrayList;
import java.util.List;

import static com.company.view.TextConstants.EMPTY_MSG;

public class GameRoom {
    private List<Toy> toys;
    private View view;

    public GameRoom(View view) {
        this.view = view;
        toys = new ArrayList<>();
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
        List<Toy> babyToys = new ArrayList<>();
        for (Toy i : toys) {
            if (i.getAgeCategory() >= 0 && i.getAgeCategory() <= 3) {
                babyToys.add(i);
            }
        }
        return babyToys;
    }


    /**
     * Prints baby toys.
     */
    public void showToysForBaby() {
        if (findToysForBaby().size() == 0) {
            view.printMessage(View.getBundleMessage(EMPTY_MSG));
        } else {
            for (Toy i : findToysForBaby()) {
                view.printMessage(i.toString());
            }
        }
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