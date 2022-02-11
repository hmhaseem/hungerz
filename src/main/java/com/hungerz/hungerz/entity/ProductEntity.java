package com.hungerz.hungerz.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "category")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;
    private String categoryId;
    private String productName;
    private String productPrice;
    private String productStatus;


}
