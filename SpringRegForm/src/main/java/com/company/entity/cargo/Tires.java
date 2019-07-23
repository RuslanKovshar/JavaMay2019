package com.company.entity.cargo;

import com.company.dto.cargo_dto.TiresDTO;
import lombok.Data;

@Data
public class Tires implements Baggage {
    private double diameter;
    private int quantity;

    public Tires(TiresDTO tiresDTO) {
        this.diameter = tiresDTO.getDiameter();
        this.quantity = tiresDTO.getQuantity();
    }

    @Override
    public double calculateShippingCost() {
        double cost = 0;
        if (diameter <= 14) {
            cost = 70;
        } else if (diameter <= 17) {
            cost = 90;
        } else if (diameter <= 19) {
            cost = 110;
        } else if (diameter <= 21) {
            cost = 130;
        } else if (diameter <= 22.5) {
            cost = 140;
        }
        return cost * quantity;
    }
}
