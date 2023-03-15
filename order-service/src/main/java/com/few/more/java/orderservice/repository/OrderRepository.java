package com.few.more.java.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.few.more.java.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

}
