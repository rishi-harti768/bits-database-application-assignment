package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class LibraryServiceTest {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private LibraryService libraryService;

    private Author author;
    private Book book;

    @BeforeEach
    public void setup() {
        author = new Author("Author 1", "Bio");
        author.setId(1L);

        book = new Book("Book 1", "Genre", 2000, author);
        book.setId(1L);
    }

    @Test
    public void testGetAllBooks() {
        when(bookRepository.findAllBooksWithAuthor()).thenReturn(Arrays.asList(book));

        List<Book> books = libraryService.getAllBooks();

        assertThat(books).hasSize(1);
        verify(bookRepository, times(1)).findAllBooksWithAuthor();
    }

    @Test
    public void testSaveBook_Success() {
        libraryService.saveBook(book);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testSaveBook_DataIntegrityViolation() {
        doThrow(new DataIntegrityViolationException("Violation")).when(bookRepository).save(book);

        assertThrows(RuntimeException.class, () -> libraryService.saveBook(book));
    }

    @Test
    public void testUpdateBook_Success() {
        when(bookRepository.existsById(1L)).thenReturn(true);
        libraryService.updateBook(book);
        verify(bookRepository, times(1)).save(book);
    }

    @Test
    public void testUpdateBook_NotFound() {
        when(bookRepository.existsById(1L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> libraryService.updateBook(book));
    }
}
