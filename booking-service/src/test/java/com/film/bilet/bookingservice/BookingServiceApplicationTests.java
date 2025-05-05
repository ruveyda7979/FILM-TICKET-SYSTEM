package com.film.bilet.bookingservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // Test profili kullanılır
class BookingServiceApplicationTests {

    @Test
    void contextLoads() {
        // Uygulama context'i doğru şekilde yükleniyor mu kontrol edilir
    }
}