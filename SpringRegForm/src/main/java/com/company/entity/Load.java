package com.company.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Load {
    private final int serviceCharge = 25;

    private String startPoint;
    private String endPoint;
    private double weight;
    private double cost;

    public double calculateShippingCost() {
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
        return 0;
    }

    private double calculate() {
        double extraFee = weight - 30;
        return extraFee * 5;
    }


}
