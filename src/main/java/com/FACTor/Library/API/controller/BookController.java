package com.FACTor.Library.API.controller;

import com.FACTor.Library.API.dto.BooksDTO;
import com.FACTor.Library.API.entity.Books;
import com.FACTor.Library.API.service.BooksLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/local-lib")
@RestController
public class BookController {
    @Autowired
    private BooksLogic logic;

    @PostMapping("/administrator/home/new-book") //Role - Admin(Liberian) -> add/upload new books
    public ResponseEntity<String> addBooks(@RequestBody BooksDTO data){
        String msg = logic.addBooks(data);
    return ResponseEntity.ok(msg);
    }

    @GetMapping("/home")
    public ResponseEntity<List<Books>> getBooks(){
       return ResponseEntity.ok(logic.getBooks());
    }

    @GetMapping("home/search")
    public ResponseEntity<List<Books>> findBook(@RequestParam String name){
          return ResponseEntity.ok(logic.getABook(name));
    }
}
