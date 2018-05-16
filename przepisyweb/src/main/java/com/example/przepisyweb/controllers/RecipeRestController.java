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

    @CrossOrigin
    @RequestMapping(value = "/Sniadanie", method = RequestMethod.GET)
    public List showRecipesSniadanie(HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");
        return databaseRecipe.showRecipes("Sniadanie");
    }

    @CrossOrigin
    @RequestMapping(value = "/Obiad", method = RequestMethod.GET)
    public List showRecipesObiad(HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");
        return databaseRecipe.showRecipes("Obiad");
    }

    @CrossOrigin
    @RequestMapping(value = "/Kolacja", method = RequestMethod.GET)
    public List showRecipesKolacja(HttpServletResponse response){

        response.setHeader("Access-Control-Allow-Origin", "*");
        return databaseRecipe.showRecipes("Kolacja");
    }


    //zwraca dobrą liste przepisow z odpowiednim typem ale nie wyswietla sie ta strona - do zmiany w js'ie i html'u
    //strona np. http://localhost:8080/recipes/Obiad.html
//    @CrossOrigin
//    @RequestMapping(value = "/recipes/{type}", method = RequestMethod.GET)
//    public List showRecipesType(@PathVariable("type") String type, HttpServletResponse response){
//
//        //ominiecie zabezpieczen przegladarki
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        String typeSplieted = type.split("\\.")[0];
//
//        return databaseRecipe.showRecipes(typeSplieted);
//    }
}
