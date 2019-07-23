package com.company.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class AppWeightAndCostDTO {
    private Double weight;
    private BigDecimal cost;
}
