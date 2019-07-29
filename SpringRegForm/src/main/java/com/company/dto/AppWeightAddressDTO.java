package com.company.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Data
public class AppWeightAddressDTO {

    @NotNull(message = "{input.weight}")
    @DecimalMin(value = "0.1", message = "{weight.must.be.greater}")
    private Double weight;

    @NotBlank(message = "{input.address}")
    private String deliveryAddress;

    private BigDecimal cost;
}
