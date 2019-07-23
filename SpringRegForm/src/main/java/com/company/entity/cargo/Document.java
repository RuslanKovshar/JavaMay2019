package com.company.entity.cargo;

import com.company.dto.cargo_dto.BaggageDTO;
import com.company.dto.cargo_dto.DocumentDTO;
import lombok.Data;

@Data
public class Document implements Baggage {
    private double weight;

    public Document(DocumentDTO documentDTO) {
        this.weight = documentDTO.getWeight();
    }

    @Override
    public double calculateShippingCost() {
        return weight <= 0.5 ? 40 : 45;
    }
}
