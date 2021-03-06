package com.example.przepisyweb.database;

import com.example.przepisyweb.models.Recipe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseRecipe {


    public DatabaseRecipe() {}


    public void addNewRecipe(Recipe recipe) {
        DatabaseConnetion mysqlConnect = new DatabaseConnetion();

        String query = " insert into recipes.recipe (title, description, image)"
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


    public List getAllRecipes(String query){
        DatabaseConnetion mysqlConnect = new DatabaseConnetion();
        List<Recipe> list = new ArrayList<Recipe>();
        try {
            PreparedStatement statement = mysqlConnect.connect().prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while(rs.next())
            {
                Recipe recipe = new Recipe(rs.getString("title"),rs.getString("description"), rs.getString("image"));
                list.add(recipe);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            mysqlConnect.disconnect();
        }

        return list;
    }

    public List showRecipes() {

        String query = " select * from recipes.recipe order by recipe.id DESC";
        return getAllRecipes(query);
    }

    public List showRecipes(String type) {

        String query = " select * from recipes.recipe where type='"+type+"' order by recipe.id DESC";
        return getAllRecipes(query);
    }




}
