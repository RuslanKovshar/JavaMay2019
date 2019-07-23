package com.company.dto.cargo_dto;

import lombok.Data;

@Data
public class LoadDTO implements BaggageDTO {
    private double weight;
    private double height;
    private double width;
    private double length;
}
