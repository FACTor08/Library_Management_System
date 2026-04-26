package com.FACTor.Library.API.controller;

import com.FACTor.Library.API.dto.AuthorDTO;
import com.FACTor.Library.API.entity.Author;
import com.FACTor.Library.API.service.AuthorLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    private AuthorLogic logic;


    @PostMapping("/administrator/home/new-author")
    public ResponseEntity<String> newUser(@RequestBody AuthorDTO data){
        String successMsg = logic.addAuthor(data);
        return ResponseEntity.ok(successMsg);
    }

    @GetMapping("/home/authors")
    public ResponseEntity<List<Author>> allAuthors(){
        List<Author> authorList = logic.availableAuthors();
        return ResponseEntity.ok(authorList);
    }
    @GetMapping("/home/authors/search")
    public ResponseEntity<List<Author>> findAnAuthor(@RequestParam String name) {
        List<Author> author = logic.findAnAuthor(name);
        return ResponseEntity.ok(author);
    }
}
