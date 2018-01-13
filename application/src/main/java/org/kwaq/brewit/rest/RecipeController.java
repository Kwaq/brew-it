package org.kwaq.brewit.rest;

import org.kwaq.brewit.entity.Recipe;
import org.kwaq.brewit.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(final RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping(path = "/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.getAllRecipes();
    }
}
