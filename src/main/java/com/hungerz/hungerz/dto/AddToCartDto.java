package com.hungerz.hungerz.dto;

import lombok.Data;

@Data
public class AddToCartDto {
    private int foodId;
    private long userId;
    private int qty;
    private double price;

}
