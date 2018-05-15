package com.example.przepisyweb.database;

import com.example.przepisyweb.models.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewUserDatabase {

    User user = new User();

    public NewUserDatabase(User user) {
        MySqlConnect mysqlConnect = new MySqlConnect();

        String query = " insert into user (firstname, lastname, login, email, password)"
                + " values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastname());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPassword());
            statement.execute();
            System.out.println("Dodano uzytkownika");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
