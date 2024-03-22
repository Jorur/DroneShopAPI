package org.dronshopapi.dronshopapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
@Table(
        name = "users",
        schema = "droneshop_db",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_username",
                        columnNames = "username"
                ),
                @UniqueConstraint(
                        name = "unique_mail",
                        columnNames = "mail"
                ),
                @UniqueConstraint(
                        name = "unique_phoneNumber",
                        columnNames = "phone_number"
                )
        }
)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String username;
    private String mail;
    private String password;
    private char gender;
    private LocalDate birthDate;
    private int phoneNumber;
    private String address;
}
