package com.app.services;

import com.app.entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.repos.BookRepository;
@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

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

}
