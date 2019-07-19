package com.company.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Load {
    private double weight;

    private final int serviceCharge = 25;

    public double calculateShippingCost() {
        if (weight <= 0.5) {
            return 40 + serviceCharge;
        }
        if (weight <= 1) {
            return 45 + serviceCharge;
        }
        if (weight <= 2) {
            return 50 + serviceCharge;
        }
        if (weight <= 5) {
            return 55 + serviceCharge;
        }
        if (weight <= 10) {
            return 65 + serviceCharge;
        }
        if (weight <= 20) {
            return 85 + serviceCharge;
        }
        if (weight <= 30) {
            return 105 + serviceCharge;
        }
        if (weight > 30) {
            return 105 + serviceCharge + calculate();
        }
        return 0;
    }

    public double calculate() {
        double extraFee = weight - 30;
        return extraFee * 5;
    }


}
