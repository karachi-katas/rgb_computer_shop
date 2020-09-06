package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.CartRepository;
import com.crafting.rgb_computer_shop.repository.model.Cart;
import com.crafting.rgb_computer_shop.repository.model.Item;

import java.util.List;

public class CartService {

    CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Item> addItems(List<Item> itemList) {
        Cart cart = new Cart();
        cart.setItems(itemList);
        return cart.getItems();
    }
}
