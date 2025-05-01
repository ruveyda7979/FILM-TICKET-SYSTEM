package com.film.bilet.userservice.service;

import com.film.bilet.userservice.entity.User;
import com.film.bilet.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Tüm kullanıcıları getir
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ID ile kullanıcı getir
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Yeni kullanıcı oluştur
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Kullanıcı güncelle
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id); // Mevcut kullanıcıyı bul
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        return userRepository.save(user); // Güncellenmiş kullanıcıyı kaydet
    }

    // Kullanıcı sil
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}