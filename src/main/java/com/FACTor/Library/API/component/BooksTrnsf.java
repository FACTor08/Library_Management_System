package com.FACTor.Library.API.component;

import com.FACTor.Library.API.dto.BooksDTO;
import com.FACTor.Library.API.entity.Books;
import org.springframework.stereotype.Component;

@Component
public class BooksTrnsf {
    public Books bookTrnsf(BooksDTO data){
        Books book = new Books();
         book.setTitle(data.getTitle());
         book.setIsbn(data.getIsbn());
        return book;
    }
}
