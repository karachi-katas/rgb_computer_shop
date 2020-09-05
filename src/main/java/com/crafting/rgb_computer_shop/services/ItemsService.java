package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Item;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ItemsService {

    private ItemRepository itemRepository;

    public List<String> getSortedItemsByPrice() {

        List<Item> items = itemRepository.findAll();
        items.sort(Comparator.comparing(Item::getPrice));
        return items.stream().map(Item::getName).collect(Collectors.toList());

    }
}
