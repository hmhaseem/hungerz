package com.hungerz.hungerz.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {


    private int orderStatus;
    private List<OrderDetailsDto> orderDetails;
    private String customerName;
    private String customerContact;
    private String customerEmail;
    private String customerAddress;
    private Double totalAmount;
}
