package com.few.more.java.orderservice.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDto {
	
	private Long id;
	private String skuCode;
	private BigDecimal price;
	private Integer quantity;

}
