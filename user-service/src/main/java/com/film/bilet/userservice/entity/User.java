package com.film.bilet.userservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Tablo adı "users" olarak ayarlanır
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Otomatik artan birincil anahtar
    private Long id;

    @Column(nullable = false) // Boş olamaz
    private String name;

    @Column(nullable = false, unique = true) // Boş olamaz ve benzersiz olmalı
    private String email;

    @Column(nullable = false) // Boş olamaz
    private String password;

    // Getter ve Setter metotları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}