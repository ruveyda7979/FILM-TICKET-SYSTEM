package com.film.bilet.movieservice.service;

import com.film.bilet.movieservice.entity.Movie;
import com.film.bilet.movieservice.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Tüm filmleri getir
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // ID ile film getir
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
    }

    // Yeni film oluştur
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Film güncelle
    public Movie updateMovie(Long id, Movie movieDetails) {
        Movie movie = getMovieById(id);
        movie.setTitle(movieDetails.getTitle());
        movie.setGenre(movieDetails.getGenre());
        movie.setDuration(movieDetails.getDuration());
        return movieRepository.save(movie);
    }

    // Film sil
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}