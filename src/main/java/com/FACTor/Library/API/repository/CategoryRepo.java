package com.FACTor.Library.API.repository;

import com.FACTor.Library.API.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

    List<Category> findByCategoryContainingIgnoreCase(String category);

    Optional<Category> findBycategoryIgnoreCase(String category);

    void deleteByCategoryIgnoreCase(String category);
}
