package com.FACTor.Library.API.controller;

import com.FACTor.Library.API.dto.CategoryDTO;
import com.FACTor.Library.API.entity.Category;
import com.FACTor.Library.API.service.CategoryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/local-lib")
public class CategoryController {
    @Autowired
    private CategoryLogic logic;

    @PostMapping("/administrator/home/new-category")
    public ResponseEntity<String> newCategory(@RequestBody CategoryDTO data){
        String successMsg = logic.newCategory(data);
        return ResponseEntity.ok(successMsg);
    }
    @GetMapping("home/category")
    public ResponseEntity<List<Category>> categories(){
       List<Category> shelves = logic.categories();
        return ResponseEntity.ok(shelves);
    }
    @GetMapping("home/category/search")
    public ResponseEntity<List<Category>> findACategory(@RequestParam String name){
        List<Category> search = logic.findACategory(name);
       return ResponseEntity.ok(search);
    }
    @DeleteMapping("/administrator/home/delete-category")
    public ResponseEntity<String> deleteCategory(@RequestParam String category){
      return ResponseEntity.ok(logic.deleteCategory(category));
    }

}
