package com.company.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Application {
    private Double weight;
    private Types type;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;
}
