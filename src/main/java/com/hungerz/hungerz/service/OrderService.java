package com.hungerz.hungerz.service;

import com.hungerz.hungerz.dto.ChangeStatusDto;
import com.hungerz.hungerz.dto.OrderDetailsDto;
import com.hungerz.hungerz.dto.OrderDetailsListDto;
import com.hungerz.hungerz.dto.OrderDto;
import com.hungerz.hungerz.entity.Foods;
import com.hungerz.hungerz.entity.Order;

import com.hungerz.hungerz.entity.OrderDetails;
import com.hungerz.hungerz.repository.FoodRepo;
import com.hungerz.hungerz.repository.OrderDetailsRepo;
import com.hungerz.hungerz.repository.OrderRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class OrderService {

    Logger logger = LoggerFactory.getLogger(OrderService.class);
    CommonResponse commonResponse = new CommonResponse();

    @Autowired
    OrderRepo orderRepo;


    @Autowired
    OrderDetailsRepo orderDetailsRepo;

    @Autowired
    FoodRepo foodRepo;

    Date date = new Date();

    @Transactional
    public CommonResponse placeOrder(OrderDto orderDto) {
        logger.info("placeOrder method access");
        try {

            Order order = new Order();
            order.setOrderStatus(orderDto.getOrderStatus());
            order.setOrderTime(date.toString());
            order.setCustomerContact(orderDto.getCustomerContact());
            order.setCustomerAddress(orderDto.getCustomerAddress());


            order.setTotalAmount(orderDto.getTotalAmount());
            Order save = orderRepo.save(order);
            for (OrderDetailsDto orderDetailsDto : orderDto.getOrderDetails()) {
                OrderDetails orderDetails = new OrderDetails();
                orderDetails.setOrderId(save.getOrderId());
                orderDetails.setFoodId(orderDetailsDto.getFoodId());
                orderDetails.setPrice(orderDetailsDto.getPrice());
                orderDetails.setQuantity(orderDetailsDto.getQuantity());
                orderDetailsRepo.save(orderDetails);

            }

            commonResponse.setStatus(true);
            commonResponse.setPayload(order);
            commonResponse.setMessage("Order placed successfully...");

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

    public CommonResponse changeStatus(ChangeStatusDto changeStatus) {
        Optional<Order> order = orderRepo.findByOrderId(changeStatus.getOrderId());
        if (order.isPresent()) {
            Order orderEntity = order.get();
            orderEntity.setOrderStatus(changeStatus.getOrderStatus());
            orderRepo.save(orderEntity);

            commonResponse.setStatus(true);
            commonResponse.setMessage("Status updated successfully");
        }

        return commonResponse;
    }

   /* public CommonResponse getOrderFood(long orderId) {
        logger.info("OrderService --> getOrderFood -> called");
        Optional<Order> order = orderRepo.findByOrderId(orderId);
        if (order.isPresent()) {
            List<OrderDetails> orderDetails = orderDetailsRepo.findByOrderId(orderId);
            if (orderDetails.isPresent()) {
                Optional<Foods> foods = foodRepo.findById(orderDetails.get());
                if (foods.isPresent()) {
                    commonResponse.setPayload(foods);
                    commonResponse.setStatus(true);

                } else {
                    commonResponse.setStatus(false);
                    commonResponse.setMessage("foods are not found");
                }
            }else {
                commonResponse.setStatus(false);
                commonResponse.setMessage("order details not found");
            }
        } else {
            commonResponse.setStatus(false);
            commonResponse.setMessage("order not found");
        }

        return commonResponse;
    }*/
}
