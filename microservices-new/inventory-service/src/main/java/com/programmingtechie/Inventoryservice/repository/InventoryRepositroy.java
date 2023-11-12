package com.programmingtechie.Inventoryservice.repository;

import com.programmingtechie.Inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface InventoryRepositroy extends JpaRepository<Inventory, Long> {

    //@Query("select i from Inventory i WHERE i.skuCode IN (:skuCode)")
    List<Inventory> findBySkuCodeIn(List<String> skuCodes);

    //@Query("select skuCode from Inventory where skuCode =: skuCode")
    //Optional<Inventory> findBySkuCode(String skuCode);

}
