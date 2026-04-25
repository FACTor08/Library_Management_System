package com.FACTor.Library.API.service;

import com.FACTor.Library.API.dto.AuthorDTO;
import com.FACTor.Library.API.component.AuthorTrnsf;
import com.FACTor.Library.API.entity.Author;
import com.FACTor.Library.API.entity.Books;
import com.FACTor.Library.API.repository.AuthorRepo;
import com.FACTor.Library.API.repository.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AuthorLogic {
    @Autowired
    private AuthorRepo repo;
    @Autowired
    private BooksRepo booksRepo;
    @Autowired
    private AuthorTrnsf transfer;

        public String addAuthor(AuthorDTO data){
            Author author = transfer.dataTrnsf(data);
    if (data.getBook() != null) {
        Books book = booksRepo.findByTitleIgnoreCase(data.getBook())
                .orElseThrow(() -> new RuntimeException("Book Not Found"));

        author.addBooks(book);
    }
            repo.save(author);

        return "New Author Successfully Added";
        }

        public List<Author> availableAuthors(){
            return repo.findAll();
        }

        public List<Author> findAnAuthor(String name){
            List<Author> authorList = repo.findByNameContainingIgnoreCase(name)
                    .orElseThrow(() -> new RuntimeException("Author Not Found"));
            if (authorList.isEmpty()){
                throw new RuntimeException("Author Not Found");
            }
            return authorList;
        }
}