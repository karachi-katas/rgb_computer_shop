package com.crafting.rgb_computer_shop;

import static org.assertj.core.api.Assertions.assertThat;

import com.crafting.rgb_computer_shop.repository.CategoryRepository;
import com.crafting.rgb_computer_shop.repository.ItemRepository;
import com.crafting.rgb_computer_shop.repository.model.Category;
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
                .thenReturn(Arrays.asList(
                        new Category("Mouse"),
                        new Category("Keyboard"),
                        new Category("Monitor")));

        List<String> categories = new CategoryService(categoryRepository).getAll();

        assertThat(categories).containsExactly("Mouse", "Keyboard", "Monitor");
    }

    @Test
    public void beAbleToListItemsInACategory(){
        String category = "Keyboard";
        Mockito.when(itemRepository.findAllByCategory_Name(category))
            .thenReturn(Arrays.asList(
                AnItem("Expensive rgb keyboard"),
                AnItem("Simple lab keyboard")
            ));

        List<Item> items = new ItemService(itemRepository).getItemsBy(category);

        assertThat(items).containsExactlyInAnyOrder(
            AnItem("Expensive rgb keyboard"),
            AnItem("Simple lab keyboard"));
    }

    @Test
    public void beAbleToListItemsSortedByPriceInACategory(){
        String category = "Keyboard";
        Mockito.when(itemRepository.findAllByCategory_Name(category))
                .thenReturn(Arrays.asList(
                        AnItem("Expensive rgb keyboard", 120.0),
                        AnItem("Simple lab keyboard", 150.0),
                        AnItem("Cheap lab keyboard", 50.0)
                ));

        List<Item> items = new ItemService(itemRepository).getSortedItemsBy(category);

        assertThat(items).containsExactly(
                AnItem("Cheap lab keyboard", 50.0),
                AnItem("Expensive rgb keyboard", 120.0),
                AnItem("Simple lab keyboard", 150.0)
        );
    }

    private Item AnItem(String itemName){
        return AnItem(itemName, 120.0);
    }

    private Item AnItem(String itemName, Double price){
        Item item = new Item();
        item.setName(itemName);
        item.setPrice(price);
        item.setCategory(new Category("Keyboard"));
        return item;
    }
}
