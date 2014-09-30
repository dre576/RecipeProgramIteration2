package controller;

import java.util.ArrayList;

import model.Category;
import model.Ingredient;
import model.Recipe;
import model.dao.CategoryDAO;
import model.dao.IngredientDAO;
import model.dao.RecipeDAO;
import model.util.searchSort;

public class RecipeController {
	public static void saveRecipe(Recipe recipe) {
		try {
			if (recipe.getIdRecipe() == null) {
				RecipeDAO.createRecipe(recipe);
			} else {
				RecipeDAO.updateRecipe(recipe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Recipe> getRecipes() {
		ArrayList<Recipe> recipes = (ArrayList<Recipe>) RecipeDAO.findAll();
		recipes = searchSort.sortRecipeAlphabetical(recipes);
		return recipes;		
	}

	public static void removeRecipe(Recipe recipe) {
		RecipeDAO.removeRecipe(recipe);
		for (Ingredient ingredient : IngredientDAO.findAll()) {
			if(ingredient.getIngredientsOfRecipe().isEmpty()){
				IngredientDAO.removeIngredient(ingredient);
			}
		}
		
		for (Category category : CategoryDAO.findAll()) {
			if(category.getRecipes().isEmpty()){
				CategoryDAO.removeCategory(category);
			}
		}
	}
}
