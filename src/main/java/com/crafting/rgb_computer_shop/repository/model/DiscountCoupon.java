package com.crafting.rgb_computer_shop.repository.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "discount_coupon")
public class DiscountCoupon {

    @Id
    private Integer id;

    private String couponCode;

    private Integer couponsLeft;

    private Double discountAmount;
}
