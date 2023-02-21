package com.BookkeeperBackendProject.models;

import jakarta.persistence.*;

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

    @OneToMany
    private Status statusEntry;

    public User(String fullName, String email, Status statusEntry) {
        this.fullName = fullName;
        this.email = email;
        this.statusEntry = statusEntry;
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

    public Status getStatusEntry() {
        return statusEntry;
    }

    public void setStatusEntry(Status statusEntry) {
        this.statusEntry = statusEntry;
    }


    // add methods
}
