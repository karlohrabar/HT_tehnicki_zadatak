package com.app.controllers;

import com.app.entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.services.BookService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Books book){
        return bookService.createBook(book);
    }
}
