package com.crafting.rgb_computer_shop.repository;

import com.crafting.rgb_computer_shop.repository.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

}
