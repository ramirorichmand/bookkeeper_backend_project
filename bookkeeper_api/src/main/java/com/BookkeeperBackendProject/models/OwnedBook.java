package com.BookkeeperBackendProject.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "status")
public class OwnedBook {

    // fix line 12
    public int getUser;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private int user_id;
    @Column
    private int book_id;
    @Column
    private String status;

    @ManyToOne
    private List<User> userList;
    @ManyToOne
    private List<Book> bookList;

    public OwnedBook(int user_id, int book_id, String status) {
        this.user_id = user_id;
        this.book_id = book_id;
        this.status = status;
        this.userList = new ArrayList<>();
        this.bookList = new ArrayList<>();
    }

    public OwnedBook() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    //
    public Object getBook() {
        return null;
    }

    public void setBook(Object book) {
    }
}
