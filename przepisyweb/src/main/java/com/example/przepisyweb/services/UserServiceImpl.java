package com.example.przepisyweb.services;

import com.example.przepisyweb.database.MySqlConnect;
import com.example.przepisyweb.database.UserDatabase;
import com.example.przepisyweb.models.Login;
import com.example.przepisyweb.models.User;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class UserServiceImpl implements UserService{

    User user;
    Login login;
    UserDatabase userDatabase = new UserDatabase();
    String resultOfLogin;

    public User getUser(){
        //User user = new User("Jan","Kowalski","JanKowal","jankowal@gmail.com","jankowal");

        return user;
    }

    @Override
    public void setUser(User user) {

        this.user = user;
    }

    public void setLogin(Login login){
        this.login = login;
    }

    public Login getLogin(){
        return login;
    }

    @Override
    public String setResult(Boolean result) {

        if (result == true) {
            resultOfLogin = "Udalo sie zalogowac.";
        } else {
            resultOfLogin = "Niepoprawny login lub haslo";
        }

        return resultOfLogin;
    }

    @Override
    public String getResult() {
        return resultOfLogin;
    }
}
