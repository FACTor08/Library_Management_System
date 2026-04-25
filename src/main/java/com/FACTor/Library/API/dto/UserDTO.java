package com.FACTor.Library.API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDTO {
    @NotNull
    @Email(message = "Enter a valid email format")
    private String email;

    @NotEmpty
    private String firstname;

    @NotNull
    @Size(min = 8, message = "Password length should be 8 Characters or more")
    private String password;

    @NotEmpty
    private String surname;
    private String phone;
}
