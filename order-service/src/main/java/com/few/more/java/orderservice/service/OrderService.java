package com.few.more.java.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.few.more.java.orderservice.dto.ItemDto;
import com.few.more.java.orderservice.dto.OrderRequest;
import com.few.more.java.orderservice.model.Item;
import com.few.more.java.orderservice.model.Order;
import com.few.more.java.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
	
	final OrderRepository orderRepository;

	public Order placeOrder(OrderRequest orderRequest) {
		
		Order order = new Order();
				order.setOrderNumber(UUID.randomUUID().toString());
				//.orderItemsList(orderRequest.getOrderItemsList()) // this is shallow cloning it will cause if any change in the copy it will affect the 
														// Original Object too thats why need to do deep cloning
				List<Item> items = orderRequest.getOrderItemsList()
												.stream()
												.map(ItemDto -> mapToDto(ItemDto))
												.toList();
				order.setOrderItemsList(items);
				 
		Order savedOrder = orderRepository.save(order);
		log.info("order placed with {} successfully ", order.getId());
		return savedOrder;
	}

	private Item mapToDto(ItemDto itemDto) { 
		 
		    Item item = new Item();
		
		    item.setSkuCode(itemDto.getSkuCode());
		    item.setPrice(itemDto.getPrice());
		    item.setQuantity(itemDto.getQuantity()); 
		
		return item;
	}
	
	
	
}
