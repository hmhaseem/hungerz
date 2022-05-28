package com.hungerz.hungerz.controller;


import com.hungerz.hungerz.dto.*;
import com.hungerz.hungerz.service.*;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin("*")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    @Autowired
    ShippingService shippingService;

    Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    @PostMapping("saveRestaurant")
    public CommonResponse saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.saveRestaurant(restaurantDto);
    }

    @CrossOrigin
    @GetMapping("listCategory")
    public CommonResponse listCategory() {
        logger.info("listCategory method access");
        return categoryService.getCategoryList();
    }

    @CrossOrigin
    @PostMapping("saveCategory")
    public CommonResponse saveCategory(@RequestBody CategoryDto categoryDto) {
        return categoryService.saveCategory(categoryDto);
    }

    @CrossOrigin
    @GetMapping("findCategory/{id}")
    public CommonResponse findCategoryById(@PathVariable int id) {
        return categoryService.findCategoryById(id);
    }

    @CrossOrigin
    @DeleteMapping("delete/{id}")
    public CommonResponse deleteById(@PathVariable int id) {
        return categoryService.deleteById(id);
    }


    @CrossOrigin
    @PostMapping("saveProduct")
    @ResponseBody
    public CommonResponse saveProduct(FoodDto foodDto, @RequestParam("file") MultipartFile file) {
        return productService.saveProduct(foodDto, file);
    }

    @CrossOrigin
    @PostMapping("updateProduct")
    @ResponseBody
    public CommonResponse updateProduct(FoodDto foodDto, @RequestParam("file") MultipartFile file) {
        return productService.updateProduct(foodDto, file);
    }

    @CrossOrigin
    @GetMapping("listProducts")
    public CommonResponse listProducts() {
        logger.info("listProducts method access");
        return productService.getAllProducts();
    }

    @CrossOrigin
    @DeleteMapping("deleteProduct/{id}")
    public CommonResponse deleteProductById(@PathVariable int id) {
        return productService.deleteById(id);
    }

    @CrossOrigin
    @PostMapping("updateCategory")
    public CommonResponse updateCategory(@RequestBody CategoryDto categoryDto) {
        logger.info("UpdateCategory method access");
        return categoryService.updateCategory(categoryDto);
    }

    @CrossOrigin
    @PostMapping("placeOrder")
    public CommonResponse placeOrder(@RequestBody OrderDto orderDto) {
        logger.info("placeOrder method access");
        return orderService.placeOrder(orderDto);
    }

    @CrossOrigin
    @GetMapping("listAllOrders")
    public CommonResponse listAllOrders() {
        logger.info("listAllOrders method access");
        return orderService.getAllOrders();
    }

    @CrossOrigin
    @PostMapping("changeOrderStatus")
    public CommonResponse changeOrderStatus(@RequestBody ChangeStatusDto changeStatus) {
        logger.info("changeOrderStatus is method accessed");
        return orderService.changeStatus(changeStatus);
    }

    @CrossOrigin
    @PostMapping("saveDelivery")
    public CommonResponse saveDelivery(@RequestBody DeliveryDto deliveryDto) {
        logger.info("saveDelivery method is access");
        return shippingService.saveDelivery(deliveryDto);
    }

    @CrossOrigin
    @PostMapping("updateDelivery")
    public CommonResponse updateDelivery(@RequestBody DeliveryDto deliveryDto) {
        logger.info("updateDelivery method is access");
        return shippingService.updateDelivery(deliveryDto);
    }

    @GetMapping("orders/foods/{orderId}")
    public CommonResponse getAllOrderFoods(@PathVariable long orderId) {
        logger.info("getAllOrderFoods -> method called");
        return orderService.getOrderFood(orderId);
    }

}
