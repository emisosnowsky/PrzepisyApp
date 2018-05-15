package com.example.przepisyweb.controllers;

import com.example.przepisyweb.database.RecipeDatabase;
import com.example.przepisyweb.models.Recipe;
import com.example.przepisyweb.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;
    RecipeDatabase recipeDatabase = new RecipeDatabase();


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
        recipeDatabase.addNewRecipe(recipe);

        return recipeService.getRecipe();
    }
}
