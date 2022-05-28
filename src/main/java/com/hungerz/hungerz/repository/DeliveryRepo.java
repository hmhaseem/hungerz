package com.hungerz.hungerz.repository;

import com.hungerz.hungerz.entity.Delivery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepo  extends JpaRepository<Delivery, Integer>, JpaSpecificationExecutor<Delivery> {
}
