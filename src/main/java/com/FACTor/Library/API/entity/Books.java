package com.FACTor.Library.API.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Books {

       private String title;
    @ManyToOne
    private Author author;
    @ManyToOne
    private Category categories;
    @Column(unique = true)
    @Id
    private String isbn;
}
