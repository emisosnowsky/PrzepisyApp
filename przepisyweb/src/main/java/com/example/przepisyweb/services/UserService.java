package com.example.przepisyweb.services;

import com.example.przepisyweb.models.Login;
import com.example.przepisyweb.models.User;

public interface UserService {

    User getUser();
    void setUser(User user);
    void setLogin(Login login);
    Login getLogin();
    String setResult(Boolean result);
    String getResult();
}
