package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.Ingredient;
import model.Recipe;
import model.database.GenericDAO;

public class RecipeDAO extends GenericDAO {
	public static void createRecipe(Recipe recipe){
	     create(recipe);
	}
	
	public static void updateRecipe(Recipe recipe){
	     update(recipe);
	}
	
	public static void removeRecipe(Recipe recipe){
	     remove(recipe);
	}
	
	public static List<Recipe> findAll(){
		
		List<Recipe> list = findAll("recipe");
	    return list;
	}
}
