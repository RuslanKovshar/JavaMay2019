package com.company.entity;

import lombok.Data;

@Data
public class Pallet implements Baggage {
    private String type;
    private int quantity;

    @Override
    public void calculateShippingCost() {

    }
}
