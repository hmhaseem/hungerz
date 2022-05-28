package com.hungerz.hungerz.repository;

import  com.hungerz.hungerz.entity.AddToCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddToCartRepo extends JpaRepository<AddToCart, Integer> {

    @Query(nativeQuery = true, value = "Select sum(addCart.price) FROM AddtoCart addCart WHERE addCart.user_id=:user_id")
    double getTotalAmountByUserId(@Param("user_id") Long user_id);

    @Query(nativeQuery = true, value = "SELECT * FROM add_to_cart WHERE user_id=?1")
    List<AddToCart> getCartByUserId(long userId);

    @Query(nativeQuery = true, value = "Select addCart  FROM add_to_cart")
    Optional<AddToCart> getCartByuserIdtest();

    @Query(nativeQuery = true, value = "SELECT * FROM add_to_cart WHERE food_id =?1 and user_id=?2")
    Optional<AddToCart> findByProductIdAndUserId(long productId, long userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE  FROM add_to_cart WHERE id=?1 and user_id=?2")
    void deleteCartByIdAndUserId(@Param("user_id") int userId, @Param("cart_id") int cartId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE  FROM add_to_cart WHERE user_id=?1")
    void deleteAllCartByUserId(int userId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "DELETE  FROM add_to_cart WHERE cart_id=?1")
    void removeAddToCart( int cartId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update add_to_cart set qty=?1, user_id=?2 WHERE id=?3")
    void updateQtyByCartId(int qty,int userId, int cartId);

}
