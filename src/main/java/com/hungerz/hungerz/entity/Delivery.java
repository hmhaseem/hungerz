package com.hungerz.hungerz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Data
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double fee;
    private String type;
    private String distance;
}
