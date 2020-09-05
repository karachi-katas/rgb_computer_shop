package com.crafting.rgb_computer_shop.repository.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany
    private List<Item> items;

    private Integer status;

}
