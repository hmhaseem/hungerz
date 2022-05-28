package com.hungerz.hungerz.dto;

import lombok.Data;

@Data
public class DeliveryDto {
    private int id;
    private String name;
    private double fee;
    private String type;
    private String distance;
}
