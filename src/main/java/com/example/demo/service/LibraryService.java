package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Autowired
    public LibraryService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAllBooksWithAuthor();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void saveBook(Book book) {
        try {
            bookRepository.save(book);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation: Book title might already exist.", e);
        }
    }

    public void updateBook(Book book) {
        try {
            if (book.getId() != null && bookRepository.existsById(book.getId())) {
                bookRepository.save(book);
            } else {
                throw new RuntimeException("Book not found for update");
            }
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Data integrity violation: Book title might already exist.", e);
        }
    }
}
