package com.FACTor.Library.API.controller;

import com.FACTor.Library.API.dto.LoanDTO;
import com.FACTor.Library.API.entity.Loan;
import com.FACTor.Library.API.entity.Status;
import com.FACTor.Library.API.service.LoanLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {
    @Autowired
    private LoanLogic logic;

    @PostMapping("/home/loan/borrow")
    public ResponseEntity<String> borrowBook(@RequestBody LoanDTO data){
        String result = logic.loanStatus(data, Status.BORROWED);
    return ResponseEntity.ok(result);
    }
    @PostMapping("/home/loan/return")
    public ResponseEntity<String> returnBook(@RequestBody LoanDTO data){
        String result = logic.loanStatus(data, Status.RETURNED);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/administrator/home/loan")
    public ResponseEntity<List<Loan>> allLoanStatus(){
        List<Loan> loans = logic.getLoans();
        return ResponseEntity.ok(loans);
    }
}
