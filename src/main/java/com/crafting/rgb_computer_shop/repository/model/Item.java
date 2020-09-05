package com.crafting.rgb_computer_shop.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "item")
public class Item implements Comparable<Item> {

    @Id
    private String id;

    private String name;

    private Double price;

    @ManyToOne
    private Category category;

    public int compareTo(Item item) {
        if (this.price > item.price)
            return 1;
        return -1;
    }
}
