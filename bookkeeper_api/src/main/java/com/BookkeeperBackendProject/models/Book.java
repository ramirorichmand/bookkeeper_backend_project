package com.BookkeeperBackendProject.models;

import jakarta.persistence.*;

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

    @OneToMany
    private Status statusEntry;

    public Book(String title, String author, String description, String genre, Status statusEntry) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
        this.statusEntry = statusEntry;
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

    public Status getStatusEntry() {
        return statusEntry;
    }

    public void setStatusEntry(Status statusEntry) {
        this.statusEntry = statusEntry;
    }

    // add method signs
}
