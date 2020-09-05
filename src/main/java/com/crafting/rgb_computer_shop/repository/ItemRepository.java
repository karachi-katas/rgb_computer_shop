package com.crafting.rgb_computer_shop.repository;

import com.crafting.rgb_computer_shop.repository.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}
