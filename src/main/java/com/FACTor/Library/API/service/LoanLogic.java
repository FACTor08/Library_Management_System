package com.FACTor.Library.API.service;

import com.FACTor.Library.API.dto.LoanDTO;
import com.FACTor.Library.API.component.LoanTrnsf;
import com.FACTor.Library.API.entity.Loan;
import com.FACTor.Library.API.entity.Status;
import com.FACTor.Library.API.repository.LoanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class LoanLogic {
    @Autowired
    private LoanRepo repo;

    @Autowired
    private LoanTrnsf transfer;

    public String loanStatus(LoanDTO data, Status status){
        Loan loan = transfer.loanTrnsf(data);
      if(status.equals(Status.BORROWED)){
          loan.setStatus(Status.BORROWED);
          loan.setBorrowedTime(LocalDateTime.now());
          repo.save(loan);
          return loan.getUser().getLibraryId() + "borrowed " + loan.getBooks().getIsbn()
                  + "at "+ loan.getBorrowedTime();
      }else
            loan.setStatus(Status.RETURNED);
    loan.setReturnedTime(LocalDateTime.now());
            repo.save(loan);
          return loan.getBooks().getIsbn() + " has been returned by " + loan.getUser().getLibraryId()
                  + "at " + loan.getReturnedTime();

    }
    public List<Loan> getLoans(){
       return repo.findAll();
    }

}
