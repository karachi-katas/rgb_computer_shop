package com.crafting.rgb_computer_shop.repository;

import com.crafting.rgb_computer_shop.repository.model.Item;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    List<Item> findAllByCategory_Name(String categoryName);

}
