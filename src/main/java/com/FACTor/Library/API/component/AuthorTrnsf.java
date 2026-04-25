package com.FACTor.Library.API.component;

import com.FACTor.Library.API.dto.AuthorDTO;
import com.FACTor.Library.API.entity.Author;
import org.springframework.stereotype.Component;


@Component
public class AuthorTrnsf {
    public Author dataTrnsf(AuthorDTO data){
        Author author = new Author();
        author.setName(data.getName());
        return author;
    }
}
