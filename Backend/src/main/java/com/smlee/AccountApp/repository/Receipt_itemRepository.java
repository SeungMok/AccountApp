package com.smlee.AccountApp.repository;

import com.smlee.AccountApp.entity.Receipt_item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Receipt_itemRepository extends JpaRepository<Receipt_item, Long> {
    
}