package com.hungerz.hungerz.repository;


import com.hungerz.hungerz.dto.OrderDetailsListDto;
import com.hungerz.hungerz.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {



    Optional<Order> findByOrderId(long orderId);
}
