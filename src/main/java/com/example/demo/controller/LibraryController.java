package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping({"/", "/books"})
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", libraryService.getAllBooks());
        return "list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "form";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            libraryService.saveBook(book);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Book book = libraryService.getBookById(id);
        if (book == null) {
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("authors", libraryService.getAllAuthors());
        return "form";
    }

    @PostMapping("/update")
    public String updateBook(@ModelAttribute("book") Book book, Model model) {
        try {
            libraryService.updateBook(book);
            return "redirect:/books";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}
