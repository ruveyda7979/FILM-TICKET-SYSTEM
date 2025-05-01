package com.film.bilet.userservice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") // --> test profili kullanılır
class UserServiceApplicationTests {

    @Test
    void contextLoads() {
        // sadece context yükleniyor mu diye kontrol edilir
    }
}
