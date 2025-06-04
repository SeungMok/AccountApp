package com.smlee.AccountApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "receipts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String store_name;
    private String payment_method;
    private int total_price;
    private java.time.LocalDateTime receipt_date;
    private java.time.LocalDateTime created_at;
    private long user_id;
}