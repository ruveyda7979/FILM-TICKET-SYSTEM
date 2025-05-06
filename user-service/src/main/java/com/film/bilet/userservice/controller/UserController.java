package com.film.bilet.userservice.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import com.film.bilet.userservice.entity.User;
import com.film.bilet.userservice.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    // Constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 🧪 Load balancing testi için instance bilgisini dönen endpoint
    @GetMapping("/test-instance")
    public String getInstanceInfo() {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            logger.info(">>> test-instance called on: " + hostName);
            return "Handled by instance: " + hostName;
        } catch (UnknownHostException e) {
            logger.error("Hostname could not be resolved", e);
            return "Handled by unknown instance";
        }
    }

    // ✅ Tüm kullanıcıları getir
    @GetMapping
    public List<User> getAllUsers() {
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            logger.info(">>> getAllUsers() called on instance: " + hostName);
        } catch (UnknownHostException e) {
            logger.warn("Hostname could not be resolved for getAllUsers");
        }
        return userService.getAllUsers();
    }

    // ✅ ID ile kullanıcı getir
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // ✅ Yeni kullanıcı oluştur
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // ✅ Kullanıcı güncelle
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    // ✅ Kullanıcı sil
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
