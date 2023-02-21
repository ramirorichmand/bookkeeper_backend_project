package com.BookkeeperBackendProject.components;

import com.BookkeeperBackendProject.models.Book;
import com.BookkeeperBackendProject.models.User;
import com.BookkeeperBackendProject.repositories.BookRepository;
import com.BookkeeperBackendProject.repositories.StatusRepository;
import com.BookkeeperBackendProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    StatusRepository statusRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Users
        User user1 = new User("Aya Hezam", "aya@bnta.com");
        userRepository.save(user1);

        User user2 = new User("Leah Simon", "leah@bnta.com");
        userRepository.save(user2);

        User user3 = new User("Ramiro Richmond", "ramiro@bnta.com");
        userRepository.save(user3);

        User user4 = new User("John Smith", "john@bnta.com");
        userRepository.save(user4);

        User user5 = new User("Jane Doe", "jane@bnta.com");
        userRepository.save(user5);


        //Books
        Book book1 = new Book("1984", "George Orwell", "A dystopian novel set in a totalitarian " +
                "society where individualism is suppressed and government surveillance is constant.", "Dystopian fiction");

        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "A coming-of-age story set in the 1930s Deep " +
                "South, exploring themes of racism, prejudice, and injustice.", "Southern Gothic.");

        Book book3 = new Book("The Catcher in the Rye", "J.D. Salinger", "A novel following a teenage " +
                "boy named Holden Caulfield as he navigates through adolescence and society's expectations.", "Coming-of-age fiction");


    }
}
