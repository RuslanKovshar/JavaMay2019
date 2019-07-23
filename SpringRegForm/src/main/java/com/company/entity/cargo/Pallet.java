package com.company.entity.cargo;

import com.company.dto.cargo_dto.PalletDTO;
import lombok.Data;

@Data
public class Pallet implements Baggage {
    private String type;
    private int quantity;

    public Pallet(PalletDTO palletDTO) {
        this.type = palletDTO.getType();
        this.quantity = palletDTO.getQuantity();
    }

    @Override
    public double calculateShippingCost() {
        double cost = 0;
        switch (type){
            case "small" : cost = 750;break;
            case "normal": cost = 1050;break;
            case "average":cost = 1575;break;
            case "big":cost = 2075;break;
        }
        return cost * quantity;
    }
}
