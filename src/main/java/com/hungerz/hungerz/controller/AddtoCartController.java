package com.hungerz.hungerz.controller;

import com.hungerz.hungerz.dto.AddToCartDto;
import com.hungerz.hungerz.entity.AddToCart;
import com.hungerz.hungerz.service.CartService;

import com.hungerz.hungerz.utility.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1/cartload/")
public class AddtoCartController {

    @Autowired
    CartService cartService;

    @CrossOrigin
    @RequestMapping("addToCart")
    public CommonResponse addCartWithProduct(@RequestBody AddToCartDto addToCartDto) {
        return cartService.addCartByUserIdAndProductId(addToCartDto);
    }

    @CrossOrigin
    @RequestMapping("listAddToCart/{userId}")
    public CommonResponse listAddToCart(@PathVariable int userId) {
        return cartService.getAllCartByUserId(userId);
    }


    @CrossOrigin
    @RequestMapping("updateQtyForCart")
    public ResponseEntity<?> updateQtyForCart(@RequestBody Map<String, String> addCartRequest) {
        try {
            int cartId = Integer.parseInt(addCartRequest.get("cartId"));
            int userId = Integer.parseInt(addCartRequest.get("userId"));
            int qty = Integer.parseInt(addCartRequest.get("qty"));

            cartService.updateQtyByCartId(qty, userId, cartId);
            List<AddToCart> obj = cartService.getCartByUserId(userId);
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @RequestMapping("removeProductFromCart")
    public ResponseEntity<?> removeCartWithProductId(@RequestBody HashMap<String, Integer> removeCartRequest) {
        try {
            List<AddToCart> obj = cartService.removeCartByUserId(removeCartRequest.get("cartId"),removeCartRequest.get("userId"));
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("getCartsByUserId")
    public ResponseEntity<?> getCartsByUserId(@RequestBody HashMap<String, String> getCartRequest) {
        try {

            List<AddToCart> obj = cartService.getCartByUserId(Long.parseLong(getCartRequest.get("userId")));
            return ResponseEntity.ok(obj);
        } catch (Exception e) {
            return null;
        }
    }
}
