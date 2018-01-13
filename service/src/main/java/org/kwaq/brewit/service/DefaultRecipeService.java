package org.kwaq.brewit.service;

import org.kwaq.brewit.dao.RecipeDao;
import org.kwaq.brewit.entity.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class DefaultRecipeService implements RecipeService {

    private static final Logger log = LoggerFactory.getLogger(DefaultRecipeService.class);

    private final RecipeDao recipeDao;

    @Autowired
    public DefaultRecipeService(final RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeDao.findAll();
    }


    @Scheduled(initialDelay = 1000, fixedDelay = 5 * 60 * 1000)
    public void create() {
        final Collection<Recipe> recipes = Arrays.asList(
                new Recipe("r1", LocalDate.now()),
                new Recipe("r2", LocalDate.now()),
                new Recipe("r3", LocalDate.now()),
                new Recipe("r4", LocalDate.now())
        );
        log.info("Saving recipes");
        recipeDao.saveAll(recipes);
        log.info("Recipes saved");
    }
}
