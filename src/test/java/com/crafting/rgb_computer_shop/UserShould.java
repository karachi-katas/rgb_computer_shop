package com.crafting.rgb_computer_shop;

import static org.assertj.core.api.Assertions.assertThat;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Cart;
import com.crafting.rgb_computer_shop.repository.model.Category;
import com.crafting.rgb_computer_shop.repository.model.Item;
import com.crafting.rgb_computer_shop.services.CategoryService;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import com.crafting.rgb_computer_shop.services.ItemsService;
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
                .thenReturn(Arrays.asList(
                        new Category("Mouse"),
                        new Category("Keyboard"),
                        new Category("Monitor")));

        List<String> categories = new CategoryService(categoryRepository).getAll();

        assertThat(categories).containsExactly("Mouse", "Keyboard", "Monitor");
    }

    @Test
    public void beAbleToGetSortedItems() {

        Mockito.when(itemRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Item("Monitor", 99.0),
                        new Item("Keyboard", 200.0),
                        new Item("Mouse", 50.0)
                ));

        List<String> sortedItems = new ItemsService(itemRepository).getSortedItemsByPrice();

        assertThat(sortedItems).containsExactly("Mouse", "Monitor", "Keyboard");
    }

    @Test
    public void beAbleToGetSortedItemsByCategory() {

        Mockito.when(itemRepository.findAll())
                .thenReturn(Arrays.asList(
                        new Item("Monitor", 99.0, new Category("PC Items")),
                        new Item("Keyboard", 200.0, new Category("PC Items")),
                        new Item("Mouse", 50.0, new Category("PC Items")),
                        new Item("PS4", 50.0, new Category("Console"))
                ));

        List<String> sortedItems = new ItemsService(itemRepository).getSortedItemsByPriceInCategory("PC Items");

        assertThat(sortedItems).containsExactly("Mouse", "Monitor", "Keyboard");
    }

    @Test
    public void beAbleToAddAnItemToTheCart(){

        Cart cart = new Cart();
        Item testItem = new Item("Monitor", 99.0, new Category("PC Items"));
        cart.addItem(testItem);

        List<Item> itemsInCart = cart.getItems();

        assertThat(itemsInCart).containsOnly(testItem);
    }

    @Test
    public void beAbleToAddItemsToTheCart(){

        Cart cart = new Cart();
        Item testItem = new Item("Monitor", 99.0, new Category("PC Items"));
        Item testItem2 = new Item("Keyboard", 55.0, new Category("PC Items"));
        cart.addItem(testItem);
        cart.addItem(testItem2);

        List<Item> itemsInCart = cart.getItems();

        assertThat(itemsInCart).containsExactly(testItem, testItem2);
    }
}
