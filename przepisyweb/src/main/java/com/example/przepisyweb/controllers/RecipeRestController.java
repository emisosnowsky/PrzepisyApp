package com.example.przepisyweb.controllers;

import com.example.przepisyweb.database.NewRecipeDatabase;
import com.example.przepisyweb.models.Recipe;
import com.example.przepisyweb.models.User;
import com.example.przepisyweb.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @CrossOrigin
    @RequestMapping(value = "/addNewRecipe", method = RequestMethod.POST)
    public Recipe addNewRecipe(@RequestBody Recipe recipe, HttpServletResponse response){

        //ominiecie zabezpieczen przegladarki
        response.setHeader("Access-Control-Allow-Origin", "*");

        recipeService.setRecipe(recipe);

        //dodawanie przepisu do bazy
        NewRecipeDatabase newRecipeDatabase = new NewRecipeDatabase(recipe);

        return recipeService.getRecipe();
    }
}
