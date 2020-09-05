package com.crafting.rgb_computer_shop;

import static org.assertj.core.api.Assertions.assertThat;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
import com.crafting.rgb_computer_shop.services.CategoryService;
import java.util.Arrays;
import java.util.List;

import com.crafting.rgb_computer_shop.services.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserShould {

    @Mock
    CategoryRepository categoryRepository;

    @Test
    public void beAbleToListAllCategories() {

        Mockito.when(categoryRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Category("Mouse"),
                        new Category("Keyboard"),
                        new Category("Monitor")));

        List<String> categories = new CategoryService(categoryRepository).getAll();

        assertThat(categories).containsExactly("Mouse", "Keyboard", "Monitor");
    }

    @Test
    public void beAbleToGetSortedListOfItemsByCategory(){

        List<String> list = new ItemService().getItemsByCategory("Mouse");

        assertThat(list).containsExactly("logitek", "microsoft", "lenovo");

    }
}
