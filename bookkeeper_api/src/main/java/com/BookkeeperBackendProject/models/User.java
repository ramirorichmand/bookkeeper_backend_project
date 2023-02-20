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
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @OneToMany
    private Status statusEntry;

    public User(String firstName, String lastName, String email, Status statusEntry) {
        this.firstName = firstName;
        this.lastName = lastName;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
