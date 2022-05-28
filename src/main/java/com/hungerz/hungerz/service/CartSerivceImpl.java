package com.hungerz.hungerz.service;


import com.hungerz.hungerz.dto.AddToCartDto;
import com.hungerz.hungerz.entity.AddToCart;
import com.hungerz.hungerz.entity.Foods;
import com.hungerz.hungerz.repository.AddToCartRepo;
import com.hungerz.hungerz.repository.FoodRepo;
import com.hungerz.hungerz.utility.CommonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartSerivceImpl implements CartService {

    @Autowired
    AddToCartRepo addCartRepo;

    @Autowired
    ProductService productService;

    @Autowired
    FoodRepo foodRepo;

    private static final Logger logger = LoggerFactory.getLogger(CartSerivceImpl.class);

    CommonResponse commonResponse = new CommonResponse();

    @Override
    public CommonResponse addCartByUserIdAndProductId(AddToCartDto addToCartDto) {
        logger.info("addCartByUserIdAndProductId Method is accessed");
        try {
            if (!addCartRepo.findByProductIdAndUserId(addToCartDto.getFoodId(), addToCartDto.getUserId()).isEmpty()) {
                logger.info("Product is already exist");
            }
            AddToCart addToCart = new AddToCart();
            addToCart.setQty(addToCartDto.getQty());
            addToCart.setUserId(addToCartDto.getUserId());
            Foods pro = productService.getProductsById(addToCartDto.getFoodId());
            //    logger.info("Pro {}", pro);

          
            addToCart.setPrice(addToCartDto.getPrice());
            addToCart.setProductName(pro.getProductName());
            addCartRepo.save(addToCart);
            commonResponse.setMessage("Food added to cart");
            commonResponse.setStatus(true);
            commonResponse.setPayload(this.getCartByUserId(addToCartDto.getUserId()));
            return commonResponse;

        } catch (Exception e) {
            e.printStackTrace();
            commonResponse.setStatus(false);
            commonResponse.setMessage("Something went wrong.. Check this" + e.getMessage());
            return commonResponse;
        }

    }

    @Override
    public CommonResponse getAllCartByUserId(int userId) {
        commonResponse.setMessage("Data retrieved successfully");
        commonResponse.setStatus(true);
        commonResponse.setPayload(addCartRepo.getCartByUserId(userId));
        return commonResponse;
    }

    @Override
    public List<AddToCart> getCartByUserId(long userId) {
        return addCartRepo.getCartByUserId(userId);
    }

    @Override
    public List<AddToCart> removeCartByUserId(int cartId, int userId) {
        addCartRepo.deleteCartByIdAndUserId(userId, cartId);
        return this.getCartByUserId(userId);
    }

    @Override
    public void updateQtyByCartId(int qty, int userId, int cartId) throws Exception {
        addCartRepo.updateQtyByCartId(qty, userId, cartId);
    }


    @Override
    public Boolean checkTotalAmountAgainstCart(double totalAmount, long userId) {
        double totalAmountByUserId = addCartRepo.getTotalAmountByUserId(userId);
        if (totalAmountByUserId == totalAmount) {
            return true;
        }
        System.out.print("Error from request " + totalAmountByUserId + " --db-- " + totalAmount);
        return false;
    }

    @Override
    public void removeAllCartByUserId(int userId) {
        addCartRepo.deleteAllCartByUserId(userId);
    }

}
