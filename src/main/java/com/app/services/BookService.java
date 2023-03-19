package com.app.services;

import com.app.entities.Books;
import com.app.repos.BookUserRepository;
import com.app.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.repos.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DecimalFormat;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;


    public String createBook(Books book){

        if(book.getAuthor_name().isEmpty() || book.getAuthor_surname().isEmpty()){
            return "The full name of the author is not provided, try again!";
        }

        if(book.getName().isEmpty()){
            return "The book name is not provided, please try again!";
        }

        if(book.getGenre().isEmpty()){
            return "The book genre is not specified, please try again!";
        }

        bookRepository.save(book);
        return "Book created!";

    }

    public String percentagebywriter(String name, String surname) {
        DecimalFormat f = new DecimalFormat("##.00");

        int left = userRepository.countUsersByAuthor(name, surname);
        int right = userRepository.countUsers();

        if(left==0)
            return "00.00%";

        return f.format((double)left/(double)right*100)+"%";

    }
}
