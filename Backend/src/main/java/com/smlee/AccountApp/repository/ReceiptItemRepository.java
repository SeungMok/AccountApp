package com.smlee.AccountApp.repository;

import com.smlee.AccountApp.entity.ReceiptItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptItemRepository extends JpaRepository<ReceiptItem, Long> {
    
}