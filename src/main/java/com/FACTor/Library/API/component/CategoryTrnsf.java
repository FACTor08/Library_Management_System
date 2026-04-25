package com.FACTor.Library.API.component;

import com.FACTor.Library.API.dto.CategoryDTO;
import com.FACTor.Library.API.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryTrnsf {
    public Category categoryTrnsf(CategoryDTO data){
        Category category = new Category();
        category.setCategory(data.getCategory());

        return category;
    }
}
