package com.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppWeightAddressDTO {

    @NotNull(message = "{input.weight}")
    @DecimalMin(value = "0.1", message = "{weight.must.be.greater}")
    private Double weight;

    @NotBlank(message = "{input.address}")
    private String deliveryAddress;
}
