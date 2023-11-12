package com.programmingtechie.Inventoryservice;

import com.programmingtechie.Inventoryservice.model.Inventory;
import com.programmingtechie.Inventoryservice.repository.InventoryRepositroy;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class InventoryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepositroy inventoryRepositroy){
		return args->{
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iPhone13");
			inventory.setQuantity(100);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iPhone13_red");
			inventory1.setQuantity(0);

			inventoryRepositroy.save(inventory);
			inventoryRepositroy.save(inventory1);
		};
	}
}
