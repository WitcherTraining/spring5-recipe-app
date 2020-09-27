package kz.springframework.spring5recipeapp.bootstrap;

import kz.springframework.spring5recipeapp.domain.*;
import kz.springframework.spring5recipeapp.repositories.CategoryRepository;
import kz.springframework.spring5recipeapp.repositories.RecipeRepository;
import kz.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(CategoryRepository categoryRepository,
                      RecipeRepository recipeRepository,
                      UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category dinner = new Category();
        dinner.setDescription("Dinner");
        categoryRepository.save(dinner);

        Category grilled = new Category();
        grilled.setDescription("Grilled");
        categoryRepository.save(grilled);

        UnitOfMeasure teaspoon = new UnitOfMeasure();
        teaspoon.setDescription("Teaspoon");
        unitOfMeasureRepository.save(teaspoon);

        UnitOfMeasure tablespoon = new UnitOfMeasure();
        tablespoon.setDescription("Tablespoon");
        unitOfMeasureRepository.save(tablespoon);

        Ingredient driedOregano = new Ingredient();
        driedOregano.setDescription("Dried oregano");

        Ingredient driedCumin = new Ingredient();
        driedCumin.setDescription("Dried cumin");

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(driedOregano);
        ingredients.add(driedCumin);

        Recipe spicyGrilledTacos = new Recipe();
        spicyGrilledTacos.setDescription("Spicy grilled chicken tacos! Quick marinade, then grill. " +
                "Ready in about 30 minutes. Great for a quick weeknight dinner, backyard cookouts, and tailgate parties");
        spicyGrilledTacos.setCookTime(15);
        spicyGrilledTacos.setDifficulty(Difficulty.EASY);
        spicyGrilledTacos.setPrepTime(20);
        spicyGrilledTacos.setServings(6);
        spicyGrilledTacos.setSource("Simply Recipes");
        spicyGrilledTacos.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        spicyGrilledTacos.setIngredients(ingredients);
        recipeRepository.save(spicyGrilledTacos);

    }
}
