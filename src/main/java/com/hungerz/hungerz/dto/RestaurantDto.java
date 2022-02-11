package com.hungerz.hungerz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {

    private String restaurantName;
    private String restaurantTagLine;
    private String restaurantAddress;
    private int restaurantContactNo;
    private String restaurantEmail;
    private String restaurantCurrency;
    private String restaurantTimeZone;
    private String restaurantLogo;
}
