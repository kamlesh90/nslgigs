package com.few.more.java.inventoryservice.service;

import com.few.more.java.inventoryservice.model.Inventory;
import com.few.more.java.inventoryservice.repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InventoryService {
    @Autowired
    private InventoryRepo inventoryRepo;
    public boolean isInStock(String skuCode){

        return inventoryRepo.findBySkuCode(skuCode).isPresent();
    }
}
