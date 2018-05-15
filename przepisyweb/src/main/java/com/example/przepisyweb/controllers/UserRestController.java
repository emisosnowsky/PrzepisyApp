package com.example.przepisyweb.controllers;

import com.example.przepisyweb.database.NewUserDatabase;
import com.example.przepisyweb.models.User;
import com.example.przepisyweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public User addNewUser(@RequestBody User user, HttpServletResponse response){

        //ominiecie zabezpieczen przegladarki
        response.setHeader("Access-Control-Allow-Origin", "*");

        userService.setUser(user);

        //dodawanie uzytkownika do bazy
        NewUserDatabase newUserDatabase = new NewUserDatabase(user);

        return userService.getUser();
    }

    @CrossOrigin
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public User logInUser(@RequestBody User user, HttpServletResponse response) {

        String login = user.getLogin();
        String password = user.getPassword();

        //sprawdzenie, czy w bazie wystepuja ten login z tym haslem

        response.setHeader("Access-Control-Allow-Origin", "*");

        return user;
    }




}
