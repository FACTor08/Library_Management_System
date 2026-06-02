package com.FACTor.Library.API.mapper;

import com.FACTor.Library.API.dto.LoanDTO;
import com.FACTor.Library.API.entity.Books;
import com.FACTor.Library.API.entity.Loan;
import com.FACTor.Library.API.entity.User;
import com.FACTor.Library.API.repository.BooksRepo;
import com.FACTor.Library.API.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BooksRepo booksRepo;

    public Loan loanTrnsf(LoanDTO data){
        Loan loan = new Loan();

        User user = userRepo.findByLibraryId(data.getLibraryId())
                        .orElseThrow(()-> new RuntimeException("User Not Found"));

        Books book = booksRepo.findByTitleIgnoreCase(data.getBookTitle())
                        .orElseThrow(()-> new RuntimeException("Book Not Found"));

        loan.setUser(user);
        loan.setBooks(book);
         return loan;
    }
}
