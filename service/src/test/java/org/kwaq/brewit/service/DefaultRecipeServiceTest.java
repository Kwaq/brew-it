package org.kwaq.brewit.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kwaq.brewit.dao.RecipeDao;
import org.kwaq.brewit.entity.Recipe;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRecipeServiceTest {

    @Mock
    private RecipeDao recipeDao;

    @InjectMocks
    private DefaultRecipeService defaultRecipeService;

    @Test
    public void shouldGetAllRecipes() throws Exception {
        //given
        final List<Recipe> recipes = Arrays.asList(
                new Recipe(1L, "recipe1", LocalDate.now()),
                new Recipe(3L, "recipe2", LocalDate.now())
        );
        given(recipeDao.findAll()).willReturn(recipes);

        //when
        final List<Recipe> allRecipes = defaultRecipeService.getAllRecipes();

        //then
        Assertions.assertThat(allRecipes).isSameAs(recipes);
    }

}