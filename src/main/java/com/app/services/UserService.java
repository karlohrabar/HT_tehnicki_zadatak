package com.app.services;

import com.app.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.repos.UserRepository;

import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Math.round;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String createUser(Users user){
        if(user.getName().isEmpty() || user.getSurname().isEmpty()){
            return "No full name provided, try again!";
        }

        if(user.getAge()<1 || user.getAge()>120){
            return "Age not valid, try again!";
        }

        userRepository.save(user);
        return "User saved!";
    }

    public int AvgAgeByGenre(String genre) {
        List<Users> users = userRepository.getUsersByGenre(genre);
        Integer sum = 0;
        if (users.isEmpty()){
            return sum;
        }
        for (Users user : users ){
            sum+=user.getAge();
        }
        return (int)round(sum.doubleValue()/users.size());
    }

}
