package com.crafting.rgb_computer_shop.repository.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category {

    @Id
    private String id;

    @Column(name = "name")
    private String name;
}

