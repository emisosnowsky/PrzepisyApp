package com.example.przepisyweb.services;

import com.example.przepisyweb.models.User;

public interface UserService {

    User getUser();
    void setUser(User user);
    String setResult(Boolean result);
    String getResult();
}
