package com.FACTor.Library.API.dto;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BooksDTO {
    @NotBlank
    private String author;

    private String title;

    @NotNull(message = "Input ISBN")
    @Min(value = 10)
    @Max(value = 13)
    private String isbn;
    @NotBlank
    private String category;
}
