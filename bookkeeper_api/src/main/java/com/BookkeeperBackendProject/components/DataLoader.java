package com.BookkeeperBackendProject.components;

import com.BookkeeperBackendProject.models.Book;
import com.BookkeeperBackendProject.models.OwnedBook;
import com.BookkeeperBackendProject.models.StatusEnum;
import com.BookkeeperBackendProject.models.User;
import com.BookkeeperBackendProject.repositories.BookRepository;
import com.BookkeeperBackendProject.repositories.OwnedBookRepository;
import com.BookkeeperBackendProject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    OwnedBookRepository ownedBookRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Users
        User user1 = new User("Aya Hezam", "aya@bnta.com");
        userRepository.save(user1);

        User user2 = new User("Leah Simon", "leah@bnta.com");
        userRepository.save(user2);

        User user3 = new User("Ramiro Richmand", "ramiro@bnta.com");
        userRepository.save(user3);

        User user4 = new User("John Smith", "john@bnta.com");
        userRepository.save(user4);

        User user5 = new User("Jane Doe", "jane@bnta.com");
        userRepository.save(user5);


        //Books
        Book book1 = new Book("1984", "George Orwell", "A dystopian novel set in a totalitarian " +
                "society where individualism is suppressed and government surveillance is constant.", "Dystopian fiction");

        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "A coming-of-age story set in the 1930s Deep " +
                "South, exploring themes of racism, prejudice, and injustice.", "Coming-of-age fiction");

        Book book3 = new Book("The Catcher in the Rye", "J.D. Salinger", "A novel following a teenage " +
                "boy named Holden Caulfield as he navigates through adolescence and society's expectations.", "Coming-of-age fiction");

        Book book4 = new Book("Pride and Prejudice", "Jane Austen", "A classic romance novel featuring witty dialogue, " +
                "complex characters, and a plot centered around love and societal expectations.", "Regency Romance");

        Book book5 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "A novel set in the Roaring Twenties that explores " +
                "themes of wealth, power, and the American Dream.", "Literary fiction");

        Book book6 = new Book("The Hobbit", "J.R.R. Tolkien", "A fantasy novel that follows Bilbo Baggins, a hobbit who " +
                "embarks on a journey with dwarves and a wizard to reclaim their treasure from a dragon.", "High fantasy");

        Book book7 = new Book("The Hunger Games", "Suzanne Collins", "A dystopian novel set in a future where teenagers are forced " +
                "to compete in a televised battle to the death as a form of entertainment for the wealthy.", "Science fiction");

        Book book8 = new Book("The Girl with the Dragon Tattoo", "Stieg Larsson", "A thriller novel following a journalist and a computer hacker " +
                "as they investigate a decades-old mystery involving a wealthy Swedish family.", "Crime fiction");

        Book book9 = new Book("The Road", "Cormac McCarthy", "A post-apocalyptic novel following a father and son as they travel " +
                "through a desolate landscape, facing starvation and danger as they search for a safe haven.", "Science fiction");

        Book book10 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "An epic fantasy novel that follows a hobbit named " +
                "Frodo Baggins as he sets out on a quest to destroy a powerful ring that could threaten the fate of Middle-earth.", "High fantasy");

        Book book11 = new Book("Animal Farm", "George Orwell", "A fable that allegorically depicts the Russian Revolution and the rise of Stalinism in the " +
                "Soviet Union.", "Political Satire");

        Book book12 = new Book("Frankenstein", "Mary Shelley", "A Gothic horror novel that explores the ethics of scientific experimentation and the consequences " +
                "of playing god.", "Gothic fiction");

        Book book13 = new Book("Sense and Sensibility", "Jane Austen", "A novel that contrasts two sisters, one ruled by reason and the other by passion, " +
                "as they navigate the societal expectations of 19th century England.", "Regency romance");

        Book book14 = new Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "A magical realism novel that follows the Buendia family over seven generations " +
                "in the fictional town of Macondo.", "Magical realism");

        Book book15 = new Book("The Sun Also Rises", "Ernest Hemingway", "A novel that explores the disillusionment of the 'Lost Generation' following " +
                "World War I through the experiences of a group of expatriates in Paris and Spain.", "Modernist fiction");

        Book book16 = new Book("The Fellowship of the Ring", "J.R.R. Tolkien", "The first volume in the 'Lord of the Rings' trilogy, which follows the " +
                "journey of a fellowship of adventurers as they attempt to destroy the One Ring.", "High fantasy");

        Book book17 = new Book("The Bell Jar", "Sylvia Plath", "A semi-autobiographical novel that depicts a young woman's descent into mental illness " +
                "and her struggle to find her place in the world.", "Autobiographical fiction");

        Book book18 = new Book("The Handmaid's Tale", "Margaret Atwood", "A dystopian novel set in a future where a theocratic government has taken over " +
                "the United States and women are subjugated and used for reproductive purposes.", "Dystopian fiction");

        Book book19 = new Book("The Adventures of Sherlock Holmes", "Arthur Conan Doyle", "A collection of 12 short stories featuring the famous detective Sherlock Holmes " +
                "and his friend Dr. Watson as they solve various mysteries.", "Crime fiction");

        Book book20 = new Book("The Picture of Dorian Gray", "Oscar Wilde", "A novel that explores the moral decay of its protagonist, a young man who remains eternally " +
                "youthful while a portrait of him ages and reflects his inner corruption.", "Gothic fiction");

        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10,
                book11, book12, book13, book14, book15, book16, book17, book18, book19, book20));


        // create and save test statuses
        OwnedBook ownedBook1 = new OwnedBook(StatusEnum.READING, user1, book1);
        OwnedBook ownedBook2 = new OwnedBook(StatusEnum.TO_READ, user2, book2);
        OwnedBook ownedBook3 = new OwnedBook(StatusEnum.READ, user3, book3);
        ownedBookRepository.saveAll(Arrays.asList(ownedBook1, ownedBook2, ownedBook3));

        //print all users, books and statuses for testing
        List<User> users = userRepository.findAll();
        System.out.println("Loaded users:");
        users.forEach(System.out::println);

        List<Book> books = bookRepository.findAll();
        System.out.println("Loaded books:");
        books.forEach(System.out::println);

        List<OwnedBook> statuses = ownedBookRepository.findAll();
        System.out.println("Loaded statuses:");
        statuses.forEach(System.out::println);

    }
}
