package com.example.demo.repository;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testFindAllBooksWithAuthor() {
        Author author = new Author("Test Author", "Bio");
        authorRepository.save(author);

        Book book = new Book("Test Book", "Test Genre", 2021, author);
        bookRepository.save(book);

        List<Book> books = bookRepository.findAllBooksWithAuthor();

        assertThat(books).isNotEmpty();
        
        boolean found = books.stream()
                .anyMatch(b -> "Test Author".equals(b.getAuthor().getName()));
        assertThat(found).isTrue();
    }
}
