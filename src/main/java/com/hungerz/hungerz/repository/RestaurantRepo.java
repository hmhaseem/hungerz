package com.hungerz.hungerz.repository;

import com.hungerz.hungerz.entity.RestaurantsEntity;
import com.hungerz.hungerz.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<RestaurantsEntity, Integer>, JpaSpecificationExecutor<RestaurantsEntity> {



}
