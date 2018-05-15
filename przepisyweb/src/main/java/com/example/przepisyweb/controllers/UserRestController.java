package com.example.przepisyweb.controllers;

import com.example.przepisyweb.database.NewUserDatabase;
import com.example.przepisyweb.models.User;
import com.example.przepisyweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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
}
