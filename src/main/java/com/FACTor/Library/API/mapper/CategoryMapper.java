package com.FACTor.Library.API.mapper;

import com.FACTor.Library.API.dto.CategoryDTO;
import com.FACTor.Library.API.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category categoryTrnsf(CategoryDTO data){
        Category category = new Category();
        category.setCategory(data.getCategory());

        return category;
    }
}
