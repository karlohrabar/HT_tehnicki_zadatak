package com.app.controllers;

import com.app.entities.BookUser;
import com.app.services.BookUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")

public class BookUserController {
    @Autowired
    private BookUserService bookUserService;

    @PostMapping("/book/{book_id}/user/{user_id}")
    public String assignBookToUser (@PathVariable long book_id, @PathVariable long user_id){
        return bookUserService.assignBookToUser(book_id,user_id);
    }

    @DeleteMapping("/book/{book_id}/user/{user_id}")
    public String deleteAssignedBookFromUser (@PathVariable long book_id, @PathVariable long user_id){
        return bookUserService.deleteAssignedBookFromUser(book_id,user_id);
    }


}
