package view;
import java.util.ArrayList;

import model.Category;
import model.Ingredient;
import model.Recipe;
import model.dao.IngredientDAO;
import model.dao.RecipeDAO;

public class Main {
	public static void main(String[] args) {		
		ArrayList<Recipe>resultList = new ArrayList<Recipe>();
		Category cat = new Category();
		ArrayList<Category> c = new ArrayList<Category>();
		Ingredient ing = new Ingredient();
		
		Recipe recipe1 = new Recipe();
		cat.setName("Italian");
		c.add(cat);
		ing.setName("cheese");
		new IngredientDAO().createIngredient(ing);
		recipe1.setDirections("put stuff on crust, cook it");
		recipe1.setTitle("Pepperoni Pizza");
		recipe1.setCategories(c);
		recipe1.getIngredients().add(ing);
		
		Recipe recipe2 = new Recipe();
		Category cat2 = new Category();
		Ingredient ing2 = new Ingredient();
		cat2.setName("Snack");
		ArrayList<Category> c2 = new ArrayList<Category>();
		c2.add(cat);
		ing2.setName("corn");
		new IngredientDAO().createIngredient(ing2);
		recipe2.setDirections("heat it up, and pop it");
		recipe2.setTitle("Pop corn");
		recipe2.setCategories(c2);
		recipe2.getIngredients().add(ing2);
		
		new RecipeDAO().createRecipe(recipe1);
		new RecipeDAO().createRecipe(recipe2);
	}
}
