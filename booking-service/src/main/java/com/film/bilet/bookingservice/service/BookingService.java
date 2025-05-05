package com.film.bilet.bookingservice.service;

import com.film.bilet.bookingservice.entity.Booking;
import com.film.bilet.bookingservice.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private final RestTemplate restTemplate;

    public BookingService(BookingRepository bookingRepository, RestTemplate restTemplate) {
        this.bookingRepository = bookingRepository;
        this.restTemplate = restTemplate;
    }

    // User servisinden kullanıcı doğrulama
    public boolean isUserValid(Long userId) {
        String userServiceUrl = "http://user-service/users/" + userId;
        try {
            restTemplate.getForObject(userServiceUrl, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Movie servisinden film doğrulama
    public boolean isMovieValid(Long movieId) {
        String movieServiceUrl = "http://movie-service/movies/" + movieId;
        try {
            restTemplate.getForObject(movieServiceUrl, Object.class);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Booking oluşturma
    public Booking createBooking(Booking booking) {
        if (!isUserValid(booking.getUserId())) {
            throw new RuntimeException("Invalid User ID");
        }
        if (!isMovieValid(booking.getMovieId())) {
            throw new RuntimeException("Invalid Movie ID");
        }
        return bookingRepository.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + id));
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}