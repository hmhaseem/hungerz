package com.hungerz.hungerz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "restaurants")
public class RestaurantsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long restaurantId;
    private String restaurantName;
    private String restaurantTagLine;
    private String restaurantAddress;
    private int restaurantContactNo;
    private String restaurantEmail;
    private String restaurantCurrency;
    private String restaurantTimeZone;
    private String restaurantLogo;

}
