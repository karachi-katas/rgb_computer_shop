package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
import com.crafting.rgb_computer_shop.repository.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.List;

public class ItemService {

    CategoryService categoryService;
    ItemRepository itemRepository;

    @Autowired
    public ItemService(
            ItemRepository itemRepository,
            CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.categoryService = categoryService;
    }

    public List<Item> getItemsByCategory(String categoryName) {

        Category category = categoryService.getByName(categoryName);

        List<Item> items = itemRepository.findByCategoryId(category.getId());

        items.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getPrice().compareTo(o2.getPrice());
            }
        });

        return items;
    }
}
