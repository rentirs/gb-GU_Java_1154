package ru.gb.mall.inventory.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.security.auth.kerberos.EncryptionKey;

@Table(name = "USERS")
@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String role;

    @Column(name = "PASSWORD", length = 1000)
    private String password;



}

