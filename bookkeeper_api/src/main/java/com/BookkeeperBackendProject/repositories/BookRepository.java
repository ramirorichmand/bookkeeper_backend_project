package com.BookkeeperBackendProject.repositories;

import com.BookkeeperBackendProject.models.Book;
import com.BookkeeperBackendProject.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByGenreContainingIgnoreCase(String genre);

    List<Book> findByStatus(Status status);


}
