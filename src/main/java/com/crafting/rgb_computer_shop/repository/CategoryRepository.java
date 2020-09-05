package com.crafting.rgb_computer_shop.repository;

import com.crafting.rgb_computer_shop.repository.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Integer> {

}
