package com.FACTor.Library.API.repository;

import com.FACTor.Library.API.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BooksRepo extends JpaRepository<Books, String> {

    List<Books> findByTitleContainingIgnoreCase(String title);

    Optional<Books> findByTitleIgnoreCase(String title);

    Optional<Books> findByIsbn(String isbn);
}
