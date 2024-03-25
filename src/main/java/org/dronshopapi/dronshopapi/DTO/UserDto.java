package org.dronshopapi.dronshopapi.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class UserDto {
    private Long id;
    private String fullName;
    private String username;
    private String mail;
    private String password;
    private char gender;
    private LocalDate birthDate;
    private int phoneNumber;
    private String address;
    private String role;
}