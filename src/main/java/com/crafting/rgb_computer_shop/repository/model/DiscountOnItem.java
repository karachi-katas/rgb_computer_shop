package com.crafting.rgb_computer_shop.repository.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "discount_on_item")
public class DiscountOnItem {

    @Id
    private Integer id;

    private Timestamp startDate;

    private Timestamp endDate;

    @ManyToOne
    private Item item;

}
