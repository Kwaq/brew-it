package org.kwaq.brewit.dao;

import org.kwaq.brewit.entity.Recipe;

import java.util.Collection;
import java.util.List;

public interface RecipeDao {

    void delete(long id);

    List<Recipe> findAll();

    Recipe getOne(long id);

    void save(Recipe recipe);

    void saveAll(Collection<Recipe> recipes);

    void update(Recipe recipe);
}
