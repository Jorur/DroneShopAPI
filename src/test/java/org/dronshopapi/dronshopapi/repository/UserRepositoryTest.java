package org.dronshopapi.dronshopapi.repository;

import org.dronshopapi.dronshopapi.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void saveMethod(){
        User user = new User();

        user.setFullName("Jorge");
        user.setUsername("Jorur");
        user.setMail("jorur45@gmail.com");
        user.setPassword("Passw0rd");
        user.setGender('M');
        user.setBirthDate(LocalDate.of(2002, 5, 30));
        user.setPhoneNumber(24681912);
        user.setAddress("Condominio Terranova");

        userRepository.save(user);
    }

    @Test
    void findAllMethod(){
        List<User> users = userRepository.findAll();

        users.forEach(user -> System.out.println(user.getFullName()));
    }

    @Test
    void deleteMethod(){
        Long id = 3L;
        userRepository.deleteById(id);
    }

}