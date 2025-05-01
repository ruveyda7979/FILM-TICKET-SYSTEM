package com.film.bilet.userservice.repository;

import com.film.bilet.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Ek sorgular gerekirse burada tanımlanabilir
}