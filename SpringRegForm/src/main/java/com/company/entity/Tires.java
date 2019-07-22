package com.company.entity;

import lombok.Data;

@Data
public class Tires implements Baggage {
    private double diameter;
    private int quantity;

    @Override
    public void calculateShippingCost() {

    }
}
