package com.hungerz.hungerz.dto;

import lombok.Data;

@Data
public class OrderDetailsDto {


    private int foodId;
    private double price;
    private int quantity;
}
