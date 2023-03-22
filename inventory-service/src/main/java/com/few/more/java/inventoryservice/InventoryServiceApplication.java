package com.few.more.java.inventoryservice;

import com.few.more.java.inventoryservice.model.Inventory;
import com.few.more.java.inventoryservice.repo.InventoryRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(InventoryRepo inventoryRepo){
		return  args -> {
			Inventory inventory1  = new Inventory();
			inventory1.setSkuCode("Iphone_13");
			inventory1.setQuantity(100);

			Inventory inventory2  = new Inventory();
			inventory2.setSkuCode("Iphone_13_Red");
			inventory2.setQuantity(0);

			inventoryRepo.save(inventory1);
			inventoryRepo.save(inventory2);
		};
	}
}
