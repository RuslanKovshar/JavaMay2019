package com.company.model;

import com.company.model.toys.Ball;
import com.company.model.toys.Cubes;
import com.company.model.toys.Doll;
import com.company.model.toys.Toy;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GameRoomTest {
    private List<Toy> toys = new ArrayList<>();
    private List<Toy> babyToys = new ArrayList<>();

    @Before
    public void setUpToysList() {
        toys.add(new Doll(11.99, 0, "test", "test"));
        toys.add(new Doll(1.99, 9, "test", "test"));
        toys.add(new Doll(20.99, 6, "test", "test"));
        toys.add(new Ball(99.99, 0, 0, "test"));
        toys.add(new Ball(50.99, 1, 0, "test"));
        toys.add(new Ball(10.99, 3, 0, "test"));
        toys.add(new Cubes(3.99, 3, 0, "test"));
        toys.add(new Cubes(2.99, 2, 0, "test"));
        toys.add(new Cubes(6.99, 4, 0, "test"));
    }

    @After
    public void deleteToysList() {
        toys.clear();
        babyToys.clear();
    }

    @Test
    public void sort() {
        for (Toy i : toys) {
            System.out.println(i.getPrice());
        }
        toys.sort(Toy::compareTo);
        for (Toy i : toys) {
            System.out.println(i.getPrice());
        }
    }

    @Test
    public void findToysForBaby() {
        for (Toy i : toys) {
            if (i.getAgeCategory() >= 0 && i.getAgeCategory() <= 3) {
                babyToys.add(i);
            }
        }
    }

    @Test
    public void showToysForBaby() {
        for (Toy i : babyToys) {
            if (i.getAgeCategory() < 0 || i.getAgeCategory() > 3) {
                Assert.fail();
            }
        }
    }
}