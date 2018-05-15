package com.example.przepisyweb.controllers;

import com.example.przepisyweb.database.UserDatabase;
import com.example.przepisyweb.models.Login;
import com.example.przepisyweb.models.User;
import com.example.przepisyweb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserRestController {

    private final UserService userService;

    UserDatabase userDatabase = new UserDatabase();
    String sResult="";

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @RequestMapping(value = "/addNewUser", method = RequestMethod.POST)
    public User addNewUser(@RequestBody User user, HttpServletResponse response) {

        //ominiecie zabezpieczen przegladarki
        response.setHeader("Access-Control-Allow-Origin", "*");

        userService.setUser(user);

        //dodawanie uzytkownika do bazy
        userDatabase.addNewUser(user);

        return userService.getUser();
    }

    @CrossOrigin
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    @ResponseBody
    public Login logInUser(@RequestBody Login login, HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");
        Boolean result;

        userService.setLogin(login);

        //sprawdzenie, czy w bazie wystepuja ten login z tym haslem
        result = userDatabase.searchForUser(login.getUsername(), login.getPassword());
        sResult = userService.setResult(result);

        return login;
    }

    //GET do sprawdzenia wyniku logowania - nieskonczony
//    @CrossOrigin
//    @RequestMapping(value = "/logInStatus", method = RequestMethod.GET)
//    public String checkResultOfLogin(HttpServletResponse response) {
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
//
//        return sResult;
//
//    }


}
