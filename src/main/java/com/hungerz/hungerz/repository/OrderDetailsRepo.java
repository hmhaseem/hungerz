package com.hungerz.hungerz.repository;

import com.hungerz.hungerz.entity.Foods;
import com.hungerz.hungerz.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer>, JpaSpecificationExecutor<Foods> {


    Optional<OrderDetails> findByOrderId(long orderId);




}
