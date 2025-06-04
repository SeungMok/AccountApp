package com.smlee.AccountApp.repository;

import com.smlee.AccountApp.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
    
}