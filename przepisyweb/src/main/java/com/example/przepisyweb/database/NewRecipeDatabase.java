package com.example.przepisyweb.database;

import com.example.przepisyweb.models.Recipe;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class NewRecipeDatabase {
    Recipe recipe = new Recipe();

    public NewRecipeDatabase(Recipe recipe) {
        MySqlConnect mysqlConnect = new MySqlConnect();

        String query = " insert into recipe (title, description, image)"
                + " values (?, ?, ?)";

        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
            statement.setString(1, recipe.getTitle());
            statement.setString(2, recipe.getDescription());
            statement.setString(3, recipe.getImage());
            statement.execute();
            System.out.println("Dodano przepis.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }
    }
}
