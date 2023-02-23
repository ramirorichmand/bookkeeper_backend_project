package com.BookkeeperBackendProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String description;
    @Column
    private String genre;

    @OneToMany(mappedBy = "book", orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private List<OwnedBook> ownedBooks;

    public Book(String title, String author, String description, String genre) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.ownedBooks= new ArrayList<>();
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public List<OwnedBook> getOwnedBooks() {
        return ownedBooks;
    }

    public void setOwnedBooks(List<OwnedBook> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }


}
