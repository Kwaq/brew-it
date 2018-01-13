package org.kwaq.brewit.dao;

import org.kwaq.brewit.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Component
public class JdbcRecipeDao implements RecipeDao {

    private static final String INSERT_SQL = "INSERT INTO RECIPE(RECIPE_NAME, CREATION_DATE) VALUES (:recipeName, :creationDate)";

    private final NamedParameterJdbcOperations jdbcOperations;

    @Autowired
    public JdbcRecipeDao(final NamedParameterJdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void delete(final long id) {
        final HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("recipeId", id);

        jdbcOperations.update("DELETE FROM RECEIPE WHERE ID = :recipeId", parameters);
    }

    @Override
    public List<Recipe> findAll() {
        final RowMapper<Recipe> rowMapper = (resultSet, i) -> {
            final long id = resultSet.getLong("ID");
            final String recipeName = resultSet.getString("RECIPE_NAME");
            final Date creationDate = resultSet.getDate("CREATION_DATE");
            return new Recipe(id, recipeName, creationDate.toLocalDate());
        };
        return jdbcOperations
                .query("SELECT ID, RECIPE_NAME, CREATION_DATE FROM RECIPE", Collections.emptyMap(),
                        rowMapper);
    }

    @Override
    public Recipe getOne(final long id) {
        return null;
    }

    @Override
    public void save(final Recipe recipe) {
        final HashMap<String, Object> parameters = createParamsMap(recipe);
        jdbcOperations.update(INSERT_SQL, parameters);
    }

    private HashMap<String, Object> createParamsMap(final Recipe recipe) {
        final HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("recipeName", recipe.getName());
        parameters.put("creationDate", recipe.getCreationDate());
        return parameters;
    }

    @Override
    public void saveAll(final Collection<Recipe> recipes) {
        final HashMap<String, Object>[] params = recipes.stream()
                .map(this::createParamsMap).toArray(value -> new HashMap[recipes.size()]);
        jdbcOperations.batchUpdate(INSERT_SQL, params);
    }

    @Override
    public void update(final Recipe recipe) {
        final HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("recipeId", recipe.getId());
        parameters.put("recipeName", recipe.getName());
        jdbcOperations.update("UPDATE RECIPE SET RECIPE_NAME = :recipeName WHERE ID = :recipeId", parameters);
    }
}
