package com.film.bilet.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
// @EnableGateway // Bu annotasyona artık gerek yok
@SpringBootApplication
@EnableDiscoveryClient  // Eureka Discovery Client için gerekli
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}