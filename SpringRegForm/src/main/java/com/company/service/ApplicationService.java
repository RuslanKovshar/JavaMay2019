package com.company.service;

import com.company.entity.Application;
import com.company.entity.Receipt;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Data
@Service
public class ApplicationService {
    private final int serviceCharge = 15;

    private Application application;

    public Receipt createReceipt() {
        return Receipt.builder()
                .application(application)
                .cost(calculateCost())
                .build();
    }

    private BigDecimal calculateCost() {
        Double weight = application.getWeight();
        double scale = 0;
        if (weight <= 0.5) {
            scale = 40;
        } else if (weight <= 1) {
            scale = 45;
        } else if (weight <= 2) {
            scale = 50;
        } else if (weight <= 5) {
            scale = 55;
        } else if (weight <= 10) {
            scale = 65;
        } else if (weight <= 20) {
            scale = 85;
        } else if (weight <= 30) {
            scale = 105;
        } else if (weight > 30) {
            scale = 105 + calculateExtraFee();
        }
        return new BigDecimal(scale + serviceCharge);
    }

    private double calculateExtraFee() {
        double extraFee = application.getWeight() - 30;
        return extraFee * 4.5;
    }
}
