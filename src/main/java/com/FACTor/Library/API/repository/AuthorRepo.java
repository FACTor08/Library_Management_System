package com.FACTor.Library.API.repository;


import com.FACTor.Library.API.entity.Author;
import com.FACTor.Library.API.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {

        Optional<Author> findBynameIgnoreCase(String name);

        Optional<List<Author>> findByNameContainingIgnoreCase(String name);
}
