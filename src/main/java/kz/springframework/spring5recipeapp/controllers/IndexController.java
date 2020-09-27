package kz.springframework.spring5recipeapp.controllers;

import kz.springframework.spring5recipeapp.domain.Category;
import kz.springframework.spring5recipeapp.domain.UnitOfMeasure;
import kz.springframework.spring5recipeapp.repositories.CategoryRepository;
import kz.springframework.spring5recipeapp.repositories.RecipeRepository;
import kz.springframework.spring5recipeapp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final RecipeRepository recipeRepository;

    public IndexController(CategoryRepository categoryRepository,
                           UnitOfMeasureRepository unitOfMeasureRepository,
                           RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model){

//        Optional<Category> optionalCategory = categoryRepository.findByDescription("American");
//        Optional<UnitOfMeasure> unitOfMeasure = unitOfMeasureRepository.findByDescription("Teaspoon");

//        System.out.println("Category ID is: " + optionalCategory.get().getId());
//        System.out.println("Unit of measure is: " + unitOfMeasure.get().getId());

        model.addAttribute("recipes", recipeRepository.findAll());

        return "index";
    }
}
