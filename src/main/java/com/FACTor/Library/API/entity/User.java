package com.FACTor.Library.API.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class User {
    @Id
    private String libraryId;
    private String email;
    private String firstname;
    private String password;
    private String surname;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Role role;
}
