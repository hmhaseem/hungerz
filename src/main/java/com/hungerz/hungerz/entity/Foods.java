package com.hungerz.hungerz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "foods")
public class Foods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int foodId;

    private int categoryId;
    private String productName;
    private String productPrice;
    private String productStatus;
    private int qty;
    private String file;



}
