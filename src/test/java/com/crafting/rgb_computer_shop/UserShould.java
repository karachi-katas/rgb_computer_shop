package com.crafting.rgb_computer_shop;

import static com.crafting.rgb_computer_shop.Fixtures.DELL_MOUSE;
import static com.crafting.rgb_computer_shop.Fixtures.KEYBOARD;
import static com.crafting.rgb_computer_shop.Fixtures.LENOVO_MOUSE;
import static com.crafting.rgb_computer_shop.Fixtures.MONITOR;
import static com.crafting.rgb_computer_shop.Fixtures.MOUSE;
import static com.crafting.rgb_computer_shop.Fixtures.RASER_MOUSE;
import static org.assertj.core.api.Assertions.assertThat;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Item;
import com.crafting.rgb_computer_shop.services.CategoryService;
import com.crafting.rgb_computer_shop.services.ItemService;
import java.util.Arrays;
import java.util.List;
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

    @Test
    public void beAbleToListAllCategories() {

        Mockito.when(categoryRepository.findAll())
                .thenReturn(Arrays.asList(MOUSE, KEYBOARD, MONITOR));

        List<String> categories = new CategoryService(categoryRepository).getAll();

        assertThat(categories).containsExactly("Mouse", "Keyboard", "Monitor");
    }

    @Test
    public void beAbleToListItemByCategorySortedByPrice() {

        Mockito.when(itemRepository.getByCategory(MOUSE)).
                thenReturn(Arrays.asList(
                        DELL_MOUSE, LENOVO_MOUSE, RASER_MOUSE));

        List<Item> items = new ItemService(itemRepository).getByCategory(MOUSE);

        assertThat(items).containsExactly(
                DELL_MOUSE, RASER_MOUSE, LENOVO_MOUSE);
    }
}
