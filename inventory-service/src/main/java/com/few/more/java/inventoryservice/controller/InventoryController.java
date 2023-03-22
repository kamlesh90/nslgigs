package com.few.more.java.inventoryservice.controller;

import com.few.more.java.inventoryservice.model.Inventory;
import com.few.more.java.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("sku-code") String skuCode){

       return inventoryService.isInStock(skuCode);
    }
}
