package com.hungerz.hungerz.service;

import com.hungerz.hungerz.entity.Order;
import com.hungerz.hungerz.repository.OrderRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OrderService {

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    CommonResponse commonResponse = new CommonResponse();

    @Autowired
    OrderRepo orderRepo;

    public CommonResponse addOrder(Order order) {
        logger.info("addOrder method access");
        try {
            Order orders = orderRepo.save(order);
            commonResponse.setStatus(true);
            commonResponse.setMessage("Order received successfully...");
            commonResponse.setPayload(orders);
        } catch (Exception e) {
            commonResponse.setStatus(false);
            commonResponse.setMessage("There is some issue due to this " + e.getMessage());
            logger.error("There is something issue due to this {}", e.getMessage());
        }

        return commonResponse;

    }

    public CommonResponse getAllOrders() {
        logger.info("getAllOrders method access");
        try {
            List<Order> orders = orderRepo.findAll();
            commonResponse.setMessage("Data retrieved successfully");
            commonResponse.setStatus(true);
            commonResponse.setPayload(orders);
        } catch (Exception e) {
            commonResponse.setStatus(false);
            commonResponse.setMessage("There is some issue in due to this " + e.getMessage());
            logger.info("There is some issue due to this : {}", e.getMessage());
        }

        return commonResponse;
    }
}
