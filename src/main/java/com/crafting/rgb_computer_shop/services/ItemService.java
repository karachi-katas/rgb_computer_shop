package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Item;

import java.util.Collections;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItemsBy(String category) {
        return itemRepository.findAllByCategory_Name(category);
    }

    public List<Item> getSortedItemsBy(String category) {
        List<Item> categoryItems = getItemsBy(category);
        Collections.sort(categoryItems);
        return categoryItems;
    }
}
