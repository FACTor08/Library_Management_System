package com.FACTor.Library.API.service;

import com.FACTor.Library.API.dto.BooksDTO;
import com.FACTor.Library.API.mapper.BooksMapper;
import com.FACTor.Library.API.entity.Author;
import com.FACTor.Library.API.entity.Books;
import com.FACTor.Library.API.entity.Category;
import com.FACTor.Library.API.repository.AuthorRepo;
import com.FACTor.Library.API.repository.BooksRepo;
import com.FACTor.Library.API.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksLogic {
    @Autowired
    private BooksMapper transfer;
    @Autowired
    private BooksRepo repo;
    @Autowired
    private AuthorRepo authorRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    public String addBooks(BooksDTO data){
        Books details = transfer.bookTrnsf(data);

       Author author = authorRepo.findBynameIgnoreCase(data.getAuthor())
                .orElseThrow(() -> new RuntimeException("Author Not Found"));
       Category category = categoryRepo.findBycategoryIgnoreCase(data.getCategory())
                .orElseThrow(() -> new RuntimeException("Category Not Found"));

        details.setAuthor(author);
        details.setCategories(category);
        repo.save(details);
        return details.getTitle() + " has been added to the shelf";
    }

    public List<Books> getBooks(){
        return repo.findAll();
    }

    public List<Books> getABook(String name){
        List<Books> title = repo.findByTitleContainingIgnoreCase(name);
        if(title.isEmpty()){
            throw new RuntimeException("Book Not Found");
        }
        return title;
    }
}
