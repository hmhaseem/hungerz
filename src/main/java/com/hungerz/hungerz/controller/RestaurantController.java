package com.hungerz.hungerz.controller;


import com.hungerz.hungerz.dto.RestaurantDto;
import com.hungerz.hungerz.dto.UserDto;
import com.hungerz.hungerz.entity.RestaurantsEntity;
import com.hungerz.hungerz.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("saveRestaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok(restaurantService.saveRestaurant(restaurantDto));
    }


}
