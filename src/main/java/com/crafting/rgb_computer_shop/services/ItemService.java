package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
import com.crafting.rgb_computer_shop.repository.model.Item;

import java.util.List;

public class ItemService {

    ItemRepository itemRepository;
    public ItemService(ItemRepository itemRepository){
        this.itemRepository=itemRepository;
    }


    public List<Item> getByCategory(Category category) {
       List<Item> itemList= itemRepository.getByCategory(category);


        return itemList;
    }
}
