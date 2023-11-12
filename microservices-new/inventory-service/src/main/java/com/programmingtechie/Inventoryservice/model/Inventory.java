package com.programmingtechie.Inventoryservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "t_inventory")
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String skuCode;
    private Integer quantity;
}
