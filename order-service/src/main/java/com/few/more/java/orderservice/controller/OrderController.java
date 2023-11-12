package com.few.more.java.orderservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.few.more.java.orderservice.dto.OrderRequest;
import com.few.more.java.orderservice.model.Order;
import com.few.more.java.orderservice.service.OrderService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

	final OrderService orderService;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		
		Order order = orderService.placeOrder(orderRequest);
		 
		return "order placed with {} successfully "+order.getId(); 
	}
}
