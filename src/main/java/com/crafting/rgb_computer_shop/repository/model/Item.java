package com.crafting.rgb_computer_shop.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
public class Item {

    @Id
    private String id;

    private String name;

    private Double price;

    @ManyToOne
    private Category category;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Item(String name, Double price, Category category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
