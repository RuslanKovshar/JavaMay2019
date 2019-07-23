package com.company.dto.cargo_dto;

import lombok.Data;

@Data
public class TiresDTO implements BaggageDTO {
    private double diameter;
    private int quantity;
}
