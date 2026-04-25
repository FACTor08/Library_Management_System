package com.FACTor.Library.API.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class AuthorDTO {
    @NotNull(message = "Input a valid Author name")
    private String name;
    private String book;
}
