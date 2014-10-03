package controller;

import model.Ingredient;
import model.dao.IngredientDAO;
import model.dao.RecipeDAO;

public class IngredientController {
	public static void saveIngredient(Ingredient ingredient) {
		try {
			if (ingredient.getIdIngredient() == null) {
				IngredientDAO.createIngredient(ingredient);
			} else {
				IngredientDAO.updateIngredient(ingredient);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Ingredient getIngredient(String name) {
		Ingredient ingredient = null;
		for (Ingredient i : IngredientDAO.findAll()) {
			if(i.getName().compareTo(name.toUpperCase()) == 0){
				ingredient = i;
			}
		};
		
		if (ingredient == null){
			ingredient = new Ingredient();
			ingredient.setName(name);
			IngredientController.saveIngredient(ingredient);
			return ingredient;
		} else return ingredient;
	}
}
