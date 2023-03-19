package com.app.services;

import com.app.entities.BookUser;
import com.app.entities.Books;
import com.app.entities.Users;
import com.app.repos.BookUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookUserService {
    @Autowired
    private BookUserRepository bookUserRepository;

    public String assignBookToUser(long bookId, long userId) {
        BookUser bookUser = new BookUser();
        bookUser.setBook_id(bookId);
        bookUser.setUser_id(userId);
        if (bookUserRepository.existsByUserIdBookId(userId,bookId) != 0){
            return "This user already likes this book!";
        }
        bookUserRepository.save(bookUser);
        return "Success!";
    }

    public String deleteAssignedBookFromUser(long bookId, long userId) {
        BookUser bookUser = bookUserRepository.findByUserIdBookId(bookId,userId);
        bookUserRepository.deleteById(bookUser.getId());
        return "Preference deleted!";
    }


}
