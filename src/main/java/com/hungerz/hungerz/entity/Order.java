package com.hungerz.hungerz.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "order_name")
    private long orderNumber;

    @Column(name = "order_time")
    private String orderTime;

    @Column(name = "order_quantity")
    private int orderQuantity;

    @Column(name = "cross_amount")
    private double crossAmount;

    @Column(name = "order_price")
    private double orderPrice;

    @Column(name = "order_status")
    private int orderStatus;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_contact")
    private String customerContact;

    @Column(name = "customer_email")
    private String customerEmail;

    @Column(name = "customer_address")
    private String customerAddress;


}
