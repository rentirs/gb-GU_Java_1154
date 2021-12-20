package ru.gb.mall.inventory.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "WAREHOUSES")
@Entity
@Data
public class WarehouseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "warehouseID", nullable = false)
    private long warehouseId;

    @Column(name = "productID", nullable = false)
    private long productId;

    @Column(name = "AMOUNT", nullable = false)
    private int amount;
}

