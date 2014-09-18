package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Ingredient;
import model.Recipe;
import model.database.GenericDAO;

public class RecipeDAO extends GenericDAO {
	public void createRecipe(Recipe recipe){
	     create(recipe);
	}
	
	public void updateRecipe(Recipe recipe){
	     update(recipe);
	}
	
	public void removeRecipe(Recipe recipe){
	     remove(recipe);
	}
	
	public  List<Recipe> findAll(){
		List<Recipe> list = findAll("recipe");
	    return list;
	}
	
	public  List<Recipe> findAllRecipesThatHaveIngredient(ArrayList<String> ingredients){
		List<Recipe> list = findAll("recipe");
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		for (Recipe recipe : list) {
			for(Ingredient ingredient: recipe.getIngredients()){
				if(ingredients.contains(ingredient.getName()))	{
					if(!recipes.contains(recipe))
						recipes.add(recipe);
				}
			}		
		}
	    return recipes;
	}
}
