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

    @Test
    void updateMethod(){
        Long id = 1L;
        User user = userRepository.findById(id).get();

        user.setUsername("teresacossiov");
        user.setMail("mariateresacossio@gmail.com");

        //Grabar producto actualizado
        userRepository.save(user);
    }
    @Test
    void saveAllMethod(){
        User user1 = new User();
        user1.setFullName("Jorge Urioste");
        user1.setUsername("jorur");
        user1.setMail("jorgeurioste@gmail.com");
        user1.setPassword("Passw0rd");
        user1.setGender('M');
        user1.setBirthDate(LocalDate.of(2002, 5, 20));
        user1.setPhoneNumber(7895641);
        user1.setAddress("Condominio TerraNova");

        User user2 = new User();
        user2.setFullName("Nicole Numberg");
        user2.setUsername("nnumberg");
        user2.setMail("nnumberg@gmail.com");
        user2.setPassword("Passw0rd");
        user2.setGender('F');
        user2.setBirthDate(LocalDate.of(2003, 4, 2));
        user2.setPhoneNumber(7895642);
        user2.setAddress("Calle Gayaramerin");

        userRepository.saveAll(List.of(user1, user2));
    }

}