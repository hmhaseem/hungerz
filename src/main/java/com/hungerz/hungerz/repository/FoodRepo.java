package com.hungerz.hungerz.repository;

import com.hungerz.hungerz.dto.FoodDto;
import com.hungerz.hungerz.entity.Foods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepo extends JpaRepository<Foods, Integer>, JpaSpecificationExecutor<Foods> {

    @Query(nativeQuery = true, value = "SELECT * FROM foods WHERE id=?1")
    Foods getById(int productId);

    @Query(nativeQuery = true, value = "SELECT * FROM foods")
    Foods getAllFoods();
    @Query(nativeQuery = true, value = "")
    Foods getFoodByOrderId();

}
