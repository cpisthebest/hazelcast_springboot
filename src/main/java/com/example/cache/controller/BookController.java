package com.example.cache.controller;

import com.example.cache.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService, BookService bookService1){
        this.bookService = bookService1;
    }

    @GetMapping("/book/{isbn}")
    public String getBook(@PathVariable String isbn){
        return bookService.getBooksByIsbn(isbn);
    }
}
