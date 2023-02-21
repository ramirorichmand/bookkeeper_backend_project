package com.BookkeeperBackendProject.repositories;

import com.BookkeeperBackendProject.models.Book;
import com.BookkeeperBackendProject.models.OwnedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OwnedBookRepository extends JpaRepository<OwnedBook, Long> {


}
