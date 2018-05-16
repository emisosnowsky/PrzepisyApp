package com.example.przepisyweb.database;

import com.example.przepisyweb.models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseUser {

    User user = new User();

    public DatabaseUser() {};

    public void addNewUser(User user){
            DatabaseConnetion mysqlConnect = new DatabaseConnetion();

            String query = " insert into recipes.user (firstname, lastname, login, email, password)"
                    + " values (?, ?, ?, ?, ?)";

            try {
                PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
                statement.setString(1, user.getFirstname());
                statement.setString(2, user.getLastname());
                statement.setString(3, user.getLogin());
                statement.setString(4, user.getEmail());
                statement.setString(5, user.getPassword());
                statement.execute();
                System.out.println("Dodano uzytkownika.");

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysqlConnect.disconnect();
            }
        }

        public boolean searchForUser(String login, String password) {

            DatabaseConnetion mysqlConnect = new DatabaseConnetion();
            Boolean result = false;

            String query = " select login, password from recipes.user"
                    + " where login = '" + login + "' and password = '" + password + "'";

            try {
                PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    result = true;
                } else {
                    result = false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                mysqlConnect.disconnect();
            }

            return result;
        }
}