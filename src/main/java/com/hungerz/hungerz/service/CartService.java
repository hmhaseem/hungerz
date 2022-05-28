package com.hungerz.hungerz.service;

import com.hungerz.hungerz.dto.AddToCartDto;
import com.hungerz.hungerz.entity.AddToCart;

import com.hungerz.hungerz.utility.CommonResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    CommonResponse addCartByUserIdAndProductId(AddToCartDto addToCartDto);

    void updateQtyByCartId(int qty, int userId, int cartId) throws Exception;

    public CommonResponse getAllCartByUserId(int userId);

    List<AddToCart> getCartByUserId(long userId);

    List<AddToCart> removeCartByUserId(int cartId, int userId);

    void removeAllCartByUserId(int userId);

    Boolean checkTotalAmountAgainstCart(double totalAmount, long userId);


    //CheckOutCart
}
