package com.smlee.AccountApp.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "receipt_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Receipt_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private int price;
    private int quantity;
    private String category;
    private java.time.LocalDateTime created_at;
    private long receipt_id;
}
