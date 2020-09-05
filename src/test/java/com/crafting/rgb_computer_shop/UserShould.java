package com.crafting.rgb_computer_shop;

import static org.assertj.core.api.Assertions.assertThat;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
import com.crafting.rgb_computer_shop.repository.model.Item;
import com.crafting.rgb_computer_shop.services.CategoryService;

import java.lang.reflect.Array;
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

    @Mock
    ItemRepository itemRepository;

    @Mock
    CategoryService categoryService;

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
    public void beAbleToGetSortedListOfItemsByCategory() {

        Item item1 = new Item(1, "logitek", 10.0);
        Item item2 = new Item(3, "lenovo", 20.0);
        Item item3 = new Item(2, "microsoft", 30.0);

        Mockito.when(categoryService.getByName("Mouse")).thenReturn(new Category(1, "Mouse"));
        Mockito.when(itemRepository.findByCategoryId(1)).thenReturn(Arrays.asList(
                item3, item2, item1
        ));

        List<Item> items = new ItemService(itemRepository, categoryService).getItemsByCategory("Mouse");

        assertThat(items).containsExactly(
                item1, item2, item3);
    }

    @Test
    public void beAbleToGetCategoryByName() {

        Category expected = new Category("Mouse");

        Mockito.when(categoryRepository.findByName("Mouse"))
                .thenReturn(expected);

        Category actualCategory = new CategoryService(categoryRepository).getByName("Mouse");

        assertThat(actualCategory).isEqualTo(expected);

    }


}
