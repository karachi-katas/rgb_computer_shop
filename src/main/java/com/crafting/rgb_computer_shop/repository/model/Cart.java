package com.crafting.rgb_computer_shop.repository.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cart")
public class Cart {

    @Id
    private Integer id;

    @ManyToMany
    @JoinTable(
        name = "cart_item",
        joinColumns = @JoinColumn(name = "cart_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    private Integer status;

}
