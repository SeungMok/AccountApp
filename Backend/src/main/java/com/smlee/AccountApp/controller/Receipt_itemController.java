package com.smlee.AccountApp.controller;

import com.smlee.AccountApp.entity.Receipt_item;
import com.smlee.AccountApp.repository.Receipt_itemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt_item")
public class Receipt_itemController {
    private final Receipt_itemRepository receipt_itemRepository;

    public Receipt_itemController(Receipt_itemRepository _receipt_itemRepository) {
        this.receipt_itemRepository = _receipt_itemRepository;
    }

    @PostMapping
    public Receipt_item createReceipt_item(@RequestBody Receipt_item _receipt_item) {
        return receipt_itemRepository.save(_receipt_item);
    }

    @GetMapping
    public List<Receipt_item> getReceipt_items() {
        return receipt_itemRepository.findAll();
    }
}
