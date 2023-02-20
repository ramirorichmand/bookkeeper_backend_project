package com.BookkeeperBackendProject.services;

import com.BookkeeperBackendProject.models.Book;
import com.BookkeeperBackendProject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
        return bookRepository.findAll(); // do this Tuesday morning
    }

    public Book getBookById(long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        Optional<Book> existingBook = bookRepository.findById(book.getId());
        if (existingBook.isPresent()){
            return bookRepository.save(book);
        } else {
            return null;
        }
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}

