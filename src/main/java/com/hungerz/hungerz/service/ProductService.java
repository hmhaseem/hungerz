package com.hungerz.hungerz.service;

import com.hungerz.hungerz.dto.RestaurantDto;
import com.hungerz.hungerz.entity.RestaurantsEntity;
import com.hungerz.hungerz.repository.RestaurantRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    RestaurantRepo restaurantRepo;

    Logger logger = LoggerFactory.getLogger(ProductService.class);

    public RestaurantsEntity saveCategory(RestaurantDto restaurantDto) {

        RestaurantsEntity restaurants = new RestaurantsEntity();
        restaurants.setRestaurantEmail(restaurantDto.getRestaurantEmail());
        restaurants.setRestaurantAddress(restaurantDto.getRestaurantAddress());
        restaurants.setRestaurantLogo(restaurantDto.getRestaurantLogo());
        restaurants.setRestaurantName(restaurantDto.getRestaurantName());
        restaurants.setRestaurantCurrency(restaurantDto.getRestaurantCurrency());
        restaurants.setRestaurantContactNo(restaurantDto.getRestaurantContactNo());
        restaurants.setRestaurantTagLine(restaurantDto.getRestaurantTagLine());
        restaurants.setRestaurantTimeZone(restaurantDto.getRestaurantTimeZone());
        logger.debug(restaurants.getRestaurantAddress());
        return restaurantRepo.save(restaurants);

    }
}
