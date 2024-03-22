package org.dronshopapi.dronshopapi.repository;

import org.dronshopapi.dronshopapi.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void saveMethod(){
        User user = new User();

        user.setFullName("Teresita");
        user.setUsername("teresita123");
        user.setMail("teresita123@gmail.com");
        user.setPassword("Passw0rd");
        user.setGender('F');
        user.setBirthDate(LocalDate.of(2002, 3, 8));
        user.setPhoneNumber(1234567);
        user.setAddress("Condominio Britannia");

        userRepository.save(user);
    }

}