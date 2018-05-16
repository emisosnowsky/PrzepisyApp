package com.example.przepisyweb.services;

import com.example.przepisyweb.models.Recipe;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

    Recipe recipe;

    @Override
    public Recipe getRecipe() {
        //Recipe recipe = new Recipe("Jajecznica","Na patelni rozpuścić łyżkę masła. Gdy stanie się płynne, wbić bezpośrednio trzy jajka. Delikatnie i bardzo wolno mieszam. Lekko solę. Gdy zaczną się ścinać dolewam 2-3 łyżki mleka lub śmietanki i smażę jeszcze przez chwilę","jajecznica");

        return recipe;
    }

    @Override
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }


}
