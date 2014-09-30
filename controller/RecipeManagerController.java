package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.Category;
import model.Ingredient;
import model.Recipe;
import model.RecipeManager;
import model.dao.CategoryDAO;
import model.dao.RecipeManagerDAO;

public class RecipeManagerController {
	public static void saveManager(RecipeManager manager) {
		try {
			if (manager.getId() == null) {
				RecipeManagerDAO.createIngredientsOfRecipe(manager);
			} else {
				RecipeManagerDAO.updateIngredientsOfRecipe(manager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createRecipe(String directions, String title,
			HashMap<String, String> ingredients, ArrayList<String> categories) {
		Recipe recipe = new Recipe();
		recipe.setTitle(title);
		recipe.setDirections(directions);		
		
		/*Saving categories*/
		for (String nameCategory : categories) {
			Category category = CategoryController.getCategory(nameCategory);
			recipe.getCategories().add(category);
		}
		
		RecipeController.saveRecipe(recipe);
		
		/*Saving ingredients*/
		Iterator it = ingredients.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			String nameIngredient = (String)pairs.getKey();
			String amountIngredient = (String)pairs.getValue();
			Ingredient ingredient = IngredientController.getIngredient(nameIngredient);
			
			RecipeManager manager = new RecipeManager();
			manager.setRecipe(recipe);
			manager.setIngredient(ingredient);
			manager.setAmount(amountIngredient);
			saveManager(manager);
			it.remove(); 
		}


	}

	public static void editRecipe(String directions, String title,
			HashMap<String, String> ingredients, ArrayList<String> categories, Recipe recipe) {
		recipe.setDirections(directions);
		recipe.setTitle(title);
		
		for (String nameCategory : categories) {
			Category category = CategoryController.getCategory(nameCategory);
			recipe.getCategories().add(category);
		}
		
		RecipeController.saveRecipe(recipe);
	}
}
