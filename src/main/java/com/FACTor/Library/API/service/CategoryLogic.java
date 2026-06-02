package com.FACTor.Library.API.service;

import com.FACTor.Library.API.dto.CategoryDTO;
import com.FACTor.Library.API.mapper.CategoryMapper;
import com.FACTor.Library.API.entity.Category;
import com.FACTor.Library.API.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategoryLogic {
    @Autowired
    private CategoryRepo repo;
    @Autowired
    private CategoryMapper transfer;

    public String newCategory(CategoryDTO data){
        Category category = transfer.categoryTrnsf(data);
        repo.save(category);
        return "New category saved as " + data.getCategory() ;
    }
    public List<Category> categories(){
        return repo.findAll();
    }
    public List<Category> findACategory(String shelf){
        List<Category> search = repo.findByCategoryContainingIgnoreCase(shelf);
        if(search.isEmpty()){
            throw new RuntimeException("Shelf Not Found");
        }
        return search;
    }

    public String deleteCategory(String name){
        repo.deleteByCategoryIgnoreCase(name);
       return "Category Successfully Deleted";
    }
}
