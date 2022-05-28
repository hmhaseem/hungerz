package com.hungerz.hungerz.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @Column(name = "order_number")
    private long orderNumber;

    @Column(name = "order_time")
    private String orderTime;

    @Column(name = "total_amount")
    private double totalAmount;

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
