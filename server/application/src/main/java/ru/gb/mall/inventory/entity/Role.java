package ru.gb.mall.inventory.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "ROLES")
@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "ROLE", nullable = false, unique = true)
    private String role;
}

