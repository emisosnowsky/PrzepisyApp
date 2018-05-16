package com.example.przepisyweb.controllers;

import com.example.przepisyweb.database.DatabaseRecipe;
import com.example.przepisyweb.models.Recipe;
import com.example.przepisyweb.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;
    DatabaseRecipe databaseRecipe = new DatabaseRecipe();


    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @CrossOrigin
    @RequestMapping(value = "/addNewRecipe", method = RequestMethod.POST)
    public Recipe addNewRecipe(@RequestBody Recipe recipe, HttpServletResponse response){

        //ominiecie zabezpieczen przegladarki
        response.setHeader("Access-Control-Allow-Origin", "*");

        //dodawanie przepisu do bazy
        databaseRecipe.addNewRecipe(recipe);

        return recipeService.getRecipe();
    }

    @CrossOrigin
    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public List showRecipes(HttpServletResponse response){

        //ominiecie zabezpieczen przegladarki
        response.setHeader("Access-Control-Allow-Origin", "*");

        return databaseRecipe.showRecipes();
    }

}
