package com.company.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class Load implements Baggage{
    private final int serviceCharge = 25;

    private String startPoint;
    private String endPoint;
    private double weight;
    private double cost;

    private double height;
    private double width;
    private double length;

    @Override
    public void calculateShippingCost() {
        if (weight <= 0.5) {
            cost = 40 + serviceCharge;
        } else if (weight <= 1) {
            cost = 45 + serviceCharge;
        } else if (weight <= 2) {
            cost = 50 + serviceCharge;
        } else if (weight <= 5) {
            cost = 55 + serviceCharge;
        } else if (weight <= 10) {
            cost = 65 + serviceCharge;
        } else if (weight <= 20) {
            cost = 85 + serviceCharge;
        } else if (weight <= 30) {
            cost = 105 + serviceCharge;
        } else if (weight > 30) {
            cost = 105 + serviceCharge + calculate();
        }
    }

    private double calculate() {
        double extraFee = weight - 30;
        return extraFee * 5;
    }


}
