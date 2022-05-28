package com.hungerz.hungerz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    private long orderId;
    private int foodId;
    private int quantity;
    private double price;
}
