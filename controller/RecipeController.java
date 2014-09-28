package controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

import model.Category;
import model.Ingredient;
import model.Recipe;
import model.dao.RecipeDAO;

public class RecipeController {

	
	public void addRecipe(String title, String directions, ArrayList<Category> categories, HashMap<Ingredient, String> ingredients ){
		
		//create recipe object.
		Recipe recipe = new Recipe();
		recipe.setTitle(title);
		recipe.setDirections(directions);
		recipe.setCategories(categories);
		recipe.setIngredients(ingredients);
		
		try{
		//add to RecipeDAO
		RecipeDAO access = new RecipeDAO();
		access.createRecipe(recipe);
		
		}
		
		catch (Exception exception)
		{
			//throw general exception.
			JOptionPane.showMessageDialog(null, "Error adding recipe to database.");
			
		}
		
	}
	//retrieves recipe from database for manipulation.
	//public Recipe getRecipe(String ID){
		
		
	//	return Recipe;
		
//	}
	
	//insert edits into parameter
	public void editRecipe(String title, String directions, ArrayList<Category> categories, HashMap<Ingredient, String> ingredients ){
		//use editID to retrieve from db
		RecipeDAO access = new RecipeDAO();
		//create recipe object.
				Recipe recipe = new Recipe();
				recipe.setTitle(title);
				recipe.setDirections(directions);
				recipe.setCategories(categories);
				recipe.setIngredients(ingredients);
				
		access.updateRecipe(recipe);
		
	}
	
	//delete recipe through I
	public void deleteRecipe(){
		
	}
	
	//add amount
	public void addIngredient(String Name){
		
	}
	
	public void addTag(String Tag)
	{
		
	}
	
	public void addDirections(String Directions)
	{
		
	}
	

	
	
}
