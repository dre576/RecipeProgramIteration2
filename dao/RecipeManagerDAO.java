package model.dao;

import java.util.List;

import model.RecipeManager;
import model.database.GenericDAO;

public class RecipeManagerDAO extends GenericDAO {
	public static void createIngredientsOfRecipe(
			RecipeManager ingredientsOfRecipe) {
		create(ingredientsOfRecipe);
	}

	public static void updateIngredientsOfRecipe(
			RecipeManager ingredientsOfRecipe) {
		update(ingredientsOfRecipe);
	}

	public static void removeIngredientsOfRecipe(
			RecipeManager ingredientsOfRecipe) {
		remove(ingredientsOfRecipe);
	}

	public static List<RecipeManager> findAll() {
		List<RecipeManager> list = findAll("recipemanager");
		return list;
	}
	
	
}
