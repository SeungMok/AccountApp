package com.smlee.AccountApp.controller;

import com.smlee.AccountApp.entity.ReceiptItem;
import com.smlee.AccountApp.repository.ReceiptItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt_item")
public class ReceiptItemController {
    private final ReceiptItemRepository ReceiptItemRepository;

    public ReceiptItemController(ReceiptItemRepository _ReceiptItemRepository) {
        this.ReceiptItemRepository = _ReceiptItemRepository;
    }

    @PostMapping
    public ReceiptItem createReceipt_item(@RequestBody ReceiptItem _receipt_item) {
        return ReceiptItemRepository.save(_receipt_item);
    }

    @GetMapping
    public List<ReceiptItem> getReceipt_items() {
        return ReceiptItemRepository.findAll();
    }
}
