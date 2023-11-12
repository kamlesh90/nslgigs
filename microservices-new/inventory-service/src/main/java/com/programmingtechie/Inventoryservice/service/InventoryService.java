package com.programmingtechie.Inventoryservice.service;

import com.programmingtechie.Inventoryservice.dto.InventoryResponse;
import com.programmingtechie.Inventoryservice.model.Inventory;
import com.programmingtechie.Inventoryservice.repository.InventoryRepositroy;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepositroy inventoryRepositroy;
    @Transactional(readOnly = true)
    public List<InventoryResponse> isAvailable(List<String> skuCodes){

        return inventoryRepositroy.findBySkuCodeIn(skuCodes).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity()>0)
                                .build()
                ).toList();
    }
}
