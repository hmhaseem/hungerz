package com.hungerz.hungerz.dto;

import com.hungerz.hungerz.entity.Foods;
import com.hungerz.hungerz.entity.OrderDetails;
import lombok.Data;

import java.util.List;

@Data
public class OrderDetailsListDto {
    private int orderStatus;
    private List<OrderDetails> orderDetails;
    private String customerName;
    private String customerContact;
    private String customerEmail;
    private String customerAddress;
    private Double totalAmount;
    private List<Foods> foods;
}
