package com.BookkeeperBackendProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ownedBooks")
public class OwnedBook {

    // fix line 12
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private Enum<StatusEnum> status;

    @Column
    private String review;

    @Column
    private int rating;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnoreProperties("ownedBooks")
    private User user;
    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    @JsonIgnoreProperties("ownedBooks")
    private Book book;

    public OwnedBook(Enum<StatusEnum> status, int rating, User user, Book book) {
        this.status = status;
        this.rating = rating;
        this.user = user;
        this.book = book;
    }

    public OwnedBook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Enum<StatusEnum> getStatus() {
        return status;
    }

    public void setStatus(Enum<StatusEnum> status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return this.book;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
