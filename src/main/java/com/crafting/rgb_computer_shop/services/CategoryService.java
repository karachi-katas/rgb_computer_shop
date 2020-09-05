package com.crafting.rgb_computer_shop.services;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(
            CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<String> getAll() {
        List<Category> categories = categoryRepository.findAll();

        List<String> categoryNames = categories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());

        return categoryNames;
    }
}
