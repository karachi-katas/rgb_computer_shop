package com.crafting.rgb_computer_shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.crafting.rgb_computer_shop.domain.CategoryService;
import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CustomerShould {

    @Mock
    CategoryRepository categoryRepository;

    @Test
    public void beAbleToListAllCategories() {

        when(categoryRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Category("Mouse"),
                        new Category("Keyboard")));

        CategoryService categoryService = new CategoryService(categoryRepository);

        List<String> categories = categoryService.getAllCategories();

        assertThat(categories).containsExactly("Mouse", "Keyboard");

    }
}
