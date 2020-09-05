package com.crafting.rgb_computer_shop.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "receipt")
public class Receipt {

    @Id
    private Integer id;

    @OneToOne
    private Cart cart;

    @ManyToOne
    private DiscountCoupon discountCoupon;

    private Double totalPriceOfItems;

    private Double totalDiscountedPrice;

    private Double payableAmountbyCustomer;


}
