package com.company.dto;

import com.company.entity.Types;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ApplicationDTO {

    @NotNull(message = "{input.weight}")
    @DecimalMin(value = "0.1", message = "{weight.must.be.greater}")
    private Double weight;

    @NotNull(message = "{input.type}")
    private Types type;

    @NotNull(message = "{input.date}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    @NotBlank(message = "{input.address}")
    private String deliveryAddress;
}
