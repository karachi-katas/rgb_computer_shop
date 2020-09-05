package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.CartRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Cart;
import com.crafting.rgb_computer_shop.repository.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class CartService {

    CartRepository cartRepository;
    final ItemRepository itemRepository;

    @Autowired
    public CartService(
            CartRepository cartRepository, ItemRepository itemRepository) { this.cartRepository = cartRepository;
        this.itemRepository = itemRepository;
    }

    public void addItem(int cartID, int itemID) {
        Item item = itemRepository.findById(itemID).get();
        Cart cart = cartRepository.findById(cartID).get();
        List<Item> cartList = cart.getItems();
        cartList.add(item);
        cart.setItems(cartList);
        cart.setId(cartID);
        cartRepository.save(cart);

    }
}
