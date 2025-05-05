package com.film.bilet.movieservice.repository;

import com.film.bilet.movieservice.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    // Ek sorgular gerekirse burada tanımlanabilir
}