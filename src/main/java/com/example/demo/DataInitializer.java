package com.example.demo;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (authorRepository.count() == 0 && bookRepository.count() == 0) {
            
            // Create 10 Authors
            Author author1 = new Author("J.K. Rowling", "British author, philanthropist, film producer, television producer, and screenwriter.");
            Author author2 = new Author("George R.R. Martin", "American novelist and short story writer in the fantasy, horror, and science fiction genres.");
            Author author3 = new Author("J.R.R. Tolkien", "English writer, poet, philologist, and university professor.");
            Author author4 = new Author("Agatha Christie", "English writer known for her 66 detective novels and 14 short story collections.");
            Author author5 = new Author("Stephen King", "American author of horror, supernatural fiction, suspense, crime, science-fiction, and fantasy novels.");
            Author author6 = new Author("Isaac Asimov", "American writer and professor of biochemistry at Boston University.");
            Author author7 = new Author("Arthur C. Clarke", "English science-fiction writer, science writer, futurist, inventor, undersea explorer, and television series host.");
            Author author8 = new Author("Jane Austen", "English novelist known primarily for her six major novels.");
            Author author9 = new Author("Charles Dickens", "English writer and social critic.");
            Author author10 = new Author("Mark Twain", "American writer, humorist, entrepreneur, publisher, and lecturer.");

            authorRepository.save(author1);
            authorRepository.save(author2);
            authorRepository.save(author3);
            authorRepository.save(author4);
            authorRepository.save(author5);
            authorRepository.save(author6);
            authorRepository.save(author7);
            authorRepository.save(author8);
            authorRepository.save(author9);
            authorRepository.save(author10);

            // Create 10 Books
            bookRepository.save(new Book("Harry Potter and the Sorcerer's Stone", "Fantasy", 1997, author1));
            bookRepository.save(new Book("A Game of Thrones", "Fantasy", 1996, author2));
            bookRepository.save(new Book("The Fellowship of the Ring", "Fantasy", 1954, author3));
            bookRepository.save(new Book("And Then There Were None", "Mystery", 1939, author4));
            bookRepository.save(new Book("The Shining", "Horror", 1977, author5));
            bookRepository.save(new Book("Foundation", "Science Fiction", 1951, author6));
            bookRepository.save(new Book("2001: A Space Odyssey", "Science Fiction", 1968, author7));
            bookRepository.save(new Book("Pride and Prejudice", "Romance", 1813, author8));
            bookRepository.save(new Book("A Tale of Two Cities", "Historical Fiction", 1859, author9));
            bookRepository.save(new Book("The Adventures of Tom Sawyer", "Adventure", 1876, author10));

            System.out.println("Initialized database with 10 authors and 10 books.");
        }
    }
}
