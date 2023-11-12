package com.programmingtechie.Inventoryservice.controller;

import com.programmingtechie.Inventoryservice.dto.InventoryResponse;
import com.programmingtechie.Inventoryservice.model.Inventory;
import com.programmingtechie.Inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    //http://localhost:8082/api/inventory/iPhone13_red,iphone13
    //http://localhost:8082/api/inventory?skuCode=iPhone13_red&iphone13

    @GetMapping
    public List<InventoryResponse> isAvailable(@RequestParam List<String> skuCodes){

        return inventoryService.isAvailable(skuCodes);
    }
}
