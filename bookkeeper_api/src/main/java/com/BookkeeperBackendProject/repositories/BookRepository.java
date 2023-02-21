package com.BookkeeperBackendProject.repositories;

import com.BookkeeperBackendProject.models.Book;
import com.BookkeeperBackendProject.models.OwnedBook;
import com.BookkeeperBackendProject.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);

    List<Book> findByAuthor(String author);

    List<Book> findByGenre(String genre);

    List<Book> findByOwnedBooksStatusAndOwnedBooksUserId(String status, long id);



}
