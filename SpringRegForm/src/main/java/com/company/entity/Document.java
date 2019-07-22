package com.company.entity;

import lombok.Data;

@Data
public class Document implements Baggage{
    private double weight;

    @Override
    public void calculateShippingCost() {

    }
}
