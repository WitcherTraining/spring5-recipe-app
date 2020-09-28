package kz.springframework.spring5recipeapp.services;

import kz.springframework.spring5recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
