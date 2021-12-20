package ru.gb.mall.inventory.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "WAREHOUSES")
@Entity
@Data
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "ADDRESS", nullable = false, unique = true)
    private String address;
}

