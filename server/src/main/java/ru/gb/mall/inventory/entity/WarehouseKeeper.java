package ru.gb.mall.inventory.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "WAREHOUSES")
@Entity
@Data
public class WarehouseKeeper {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "E-MAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "WAREHOUSE_ID", nullable = false)
    private String warehouseId;
}

