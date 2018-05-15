package com.example.przepisyweb.controllers;

import com.example.przepisyweb.database.UserDatabase;
import com.example.przepisyweb.models.User;
import com.example.przepisyweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserRestController {

    private final UserService userService;

    UserDatabase userDatabase = new UserDatabase();

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
        userDatabase.addNewUser(user);

        return userService.getUser();
    }

    @CrossOrigin
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public User logInUser(@RequestBody User user, HttpServletResponse response) {

        String login = user.getLogin();
        String password = user.getPassword();
        Boolean result;

        //sprawdzenie, czy w bazie wystepuja ten login z tym haslem
        result = userDatabase.searchForUser(login, password);

        if(result==true){
            System.out.println("wszystko sie zgadza, happy wszyscy");
        } else {
            System.out.println("niestety nie ma takiego uzytkownika");
        }

        response.setHeader("Access-Control-Allow-Origin", "*");

        return user;
    }




}
