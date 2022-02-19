package com.hungerz.hungerz.controller;


import com.hungerz.hungerz.dto.CategoryDto;
import com.hungerz.hungerz.dto.ProductDto;
import com.hungerz.hungerz.dto.RestaurantDto;
import com.hungerz.hungerz.dto.UserDto;
import com.hungerz.hungerz.entity.RestaurantsEntity;
import com.hungerz.hungerz.service.CategoryService;
import com.hungerz.hungerz.service.ProductService;
import com.hungerz.hungerz.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;


    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;


    @PostMapping("saveRestaurant")
    public ResponseEntity<?> saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return ResponseEntity.ok(restaurantService.saveRestaurant(restaurantDto));
    }

    @CrossOrigin
    @GetMapping("listCategory")
    public ResponseEntity<Map> listCategory() {

        Map map = new HashMap();
        map.put("status", "success");
        map.put("result", categoryService.getCategoryList());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping("saveCategory")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryService.saveCategory(categoryDto));
    }

    @GetMapping("findCategory/{id}")
    public ResponseEntity<?>findCategoryById(@PathVariable int id){
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

    @PostMapping("saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }


}
