package com.FACTor.Library.API.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BooksDTO {
    @NotBlank
    private String author;
    @NotBlank
    private String title;

    @NotNull(message = "Input ISBN")
    @Min(value = 10)
    @Max(value = 13)
    private String isbn;
    @NotBlank
    private String category;
}
