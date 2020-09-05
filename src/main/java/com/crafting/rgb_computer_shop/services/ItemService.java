package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemService {

    ItemRepository itemRepository;


    @Autowired
    public ItemService(
            ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getItemsByCategory(String category) {





        return null;
    }
}
