package com.hungerz.hungerz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "add_to_cart")
@Data
public class AddToCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    @JsonIgnore

    @Column(name = "qty")
    int qty;

    @Column(name = "price")
    double price;

    @Column(name = "user_id")
    Long userId;

    @Column(updatable = false, insertable = false)
    String addedDate;


    @Column(name = "product_name")
    String productName;


}
