package com.crafting.rgb_computer_shop;

import static org.assertj.core.api.Assertions.assertThat;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
import com.crafting.rgb_computer_shop.repository.model.Item;
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

    public static final Category MOUSE = new Category("Mouse");
    @Mock
    CategoryRepository categoryRepository;
    @Mock
    ItemRepository itemRepository;

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
    public void beAbleToListItemByCategory(){

        Item dellMouse = new Item("Dell_Mouse",1000,new Category("Mouse"));
        Item lenovoMouse = new Item("Lenovo_Mouse",1500,new Category("Mouse"));
        Item raserMouse = new Item("Raser_Mouse",5000,new Category("Mouse"));
        Item dellKeyboard = new Item("Dell_Keyboard",1000,new Category("Keyboard"));

        Mockito.when(itemRepository.getByCategory(MOUSE)).
                thenReturn(Arrays.asList(dellMouse,lenovoMouse,raserMouse));

        List<Item> items = new ItemService(itemRepository).getByCategory(MOUSE);


        assertThat(items).containsExactly(dellMouse,lenovoMouse,raserMouse);
    }
}
