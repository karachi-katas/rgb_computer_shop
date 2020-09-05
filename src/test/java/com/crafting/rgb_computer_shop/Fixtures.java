package com.crafting.rgb_computer_shop;

import com.crafting.rgb_computer_shop.repository.model.Category;
import com.crafting.rgb_computer_shop.repository.model.Item;

public class Fixtures {

    public static final Category MOUSE = new Category("Mouse");
    public static final Category KEYBOARD = new Category("Keyboard");
    public static final Category MONITOR = new Category("Monitor");
    public static final Item DELL_MOUSE = new Item("Dell_Mouse", 1000, new Category("Mouse"));
    public static final Item LENOVO_MOUSE = new Item("Lenovo_Mouse", 7000, new Category("Mouse"));
    public static final Item RASER_MOUSE = new Item("Raser_Mouse", 5000, new Category("Mouse"));
}
