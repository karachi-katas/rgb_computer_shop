package com.crafting.rgb_computer_shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/")
public class CategoryController {

    @GetMapping(value = "hello")
    public String hello() {
        return "RGB Tomcat";
    }


}
