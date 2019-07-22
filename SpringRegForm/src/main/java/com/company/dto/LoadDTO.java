package com.company.dto;

import lombok.Data;

@Data
public class LoadDTO {
    private String startPoint;
    private String endPoint;
    private double weight;

    private double height;
    private double width;
    private double length;
}
