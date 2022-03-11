package com.hungerz.hungerz.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hungerz.hungerz.dto.RestaurantDto;
import com.hungerz.hungerz.entity.RestaurantsEntity;
import com.hungerz.hungerz.repository.RestaurantRepo;


import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    Logger logger = LoggerFactory.getLogger(RestaurantService.class);

    public CommonResponse saveRestaurant(RestaurantDto restaurantDto) {
        logger.info("saveRestaurant Method access");
        CommonResponse commonResponse = new CommonResponse();
        ObjectMapper mapper = new ObjectMapper();
        RestaurantsEntity restaurants = mapper.convertValue(restaurantDto, RestaurantsEntity.class);
        restaurantRepo.save(restaurants);
        commonResponse.setStatus(true);
        commonResponse.setMessage("Restaurant Saved successfully");
        commonResponse.setPayload(restaurants);
        return commonResponse;
    }
}
