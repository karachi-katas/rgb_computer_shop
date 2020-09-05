package com.crafting.rgb_computer_shop.repository;

import com.crafting.rgb_computer_shop.repository.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {

}
