package com.smlee.AccountApp.controller;

import com.smlee.AccountApp.entity.Receipt;
import com.smlee.AccountApp.repository.ReceiptRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receipt")
public class ReceiptController {
    private final ReceiptRepository receiptRepository;

    public ReceiptController(ReceiptRepository _receiptRepository) {
        this.receiptRepository = _receiptRepository;
    }

    @PostMapping
    public Receipt createReceipt(@RequestBody Receipt _receipt) {
        return receiptRepository.save(_receipt);
    }

    @GetMapping
    public List<Receipt> getReceipt() {
        return receiptRepository.findAll();
    }
}
