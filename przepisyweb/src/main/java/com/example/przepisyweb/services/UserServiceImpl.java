package com.example.przepisyweb.services;

import com.example.przepisyweb.database.MySqlConnect;
import com.example.przepisyweb.database.UserDatabase;
import com.example.przepisyweb.models.User;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService{

    User user;
    UserDatabase userDatabase = new UserDatabase();

    public User getUser(){
        //User user = new User("Jan","Kowalski","JanKowal","jankowal@gmail.com","jankowal");

        return user;
    }

    @Override
    public void setUser(User user) {

        this.user = user;
    }
}
