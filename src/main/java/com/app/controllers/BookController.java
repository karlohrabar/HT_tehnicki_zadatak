package com.app.controllers;

import com.app.entities.Books;
import com.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.app.services.BookService;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/addBook")
    public String addBook(@RequestBody Books book){
        return bookService.createBook(book);
    }

    @GetMapping("/percentagebywriter")
    public Object percentage(String author_name, String author_surname){
        Map<String, Object> object = new HashMap<>();
        object.put("Percentage for " + author_name + " " + author_surname, bookService.percentagebywriter(author_name, author_surname));
        return object;
    }
}
