package com.alvaro.login_demo.user;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")



public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true, length = 200)
    private String email;
    @Column(name = "password_hash", nullable = false, length = 100)
    private String passwordHash; 

    private String nombre;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private java.sql.Timestamp createdAt;
   
}
