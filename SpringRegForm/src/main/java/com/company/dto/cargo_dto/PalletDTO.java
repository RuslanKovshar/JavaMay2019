package com.company.dto.cargo_dto;

import lombok.Data;

@Data
public class PalletDTO implements BaggageDTO {
    private String type;
    private int quantity;
}
