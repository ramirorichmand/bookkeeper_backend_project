package com.BookkeeperBackendProject.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String fullName;

    @Column
    private String email;


    @OneToMany(mappedBy = "user", orphanRemoval = true)
    @JsonIgnoreProperties("user")
    private List<OwnedBook> ownedBooks;


    public User(String fullName, String email) {
        this.fullName = fullName;
        this.email = email;
        this.ownedBooks = new ArrayList<>();
    }

    public User() {
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<OwnedBook> getOwnedBooks() {
        return ownedBooks;
    }

    public void setOwnedBooks(List<OwnedBook> ownedBooks) {
        this.ownedBooks = ownedBooks;
    }
}
