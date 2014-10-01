import java.util.ArrayList;
import java.util.HashMap;

import model.Recipe;
import model.Category;
import model.Ingredient;
import model.RecipeManager;
import controller.RecipeManagerController;
import controller.searchSort;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;


public class unitTests {
	
	

	@Test
	public void testSearchByName() 
	{
		//creates two recipes puts them in an arraylist to be passed into method
		//creates another arraylist to hold expected result of search
		ArrayList<Recipe>recipeList = new ArrayList<Recipe>();
		ArrayList<Recipe>resultList = new ArrayList<Recipe>();
		Category cat = new Category();
		ArrayList<Category> c = new ArrayList<Category>();
		Ingredient ing = new Ingredient();
		ArrayList<Ingredient> i = new ArrayList<Ingredient>();
		
		Recipe recipe1 = new Recipe();
		cat.setName("Italian");
		c.add(cat);
		ing.setName("cheese");
		i.add(ing);
		recipe1.setDirections("put stuff on crust, cook it");
		recipe1.setTitle("Pepperoni Pizza");
		recipe1.setCategories(c);
		//recipe1.setIngredients(i);
		
		recipeList.add(recipe1);
		
		
		Recipe recipe2 = new Recipe();
		Category cat2 = new Category();
		Ingredient ing2 = new Ingredient();
		cat2.setName("Snack");
		ArrayList<Category> c2 = new ArrayList<Category>();
		ArrayList<Ingredient> i2 = new ArrayList<Ingredient>();
		c2.add(cat2);
		ing2.setName("corn");
		i2.add(ing2);
		recipe2.setDirections("heat it up, and pop it");
		recipe2.setTitle("Pop corn");
		recipe2.setCategories(c2);
		//recipe2.setIngredients(i2);
		
		recipeList.add(recipe2);
		resultList.add(recipe1);
	    
	    assertEquals(resultList, searchSort.searchByName("Pepperoni", recipeList));
	}
	
	@Test
	public void testSearchByCategory() 
	{
		//creates two recipes puts them in an arraylist to be passed into method
		//creates another arraylist to hold expected result of search
		ArrayList<Recipe>recipeList = new ArrayList<Recipe>();
		ArrayList<Recipe>resultList = new ArrayList<Recipe>();
		Category cat = new Category();
		ArrayList<Category> c = new ArrayList<Category>();
		Ingredient ing = new Ingredient();
ArrayList<Ingredient> i = new ArrayList<Ingredient>();
		
		Recipe recipe1 = new Recipe();
		cat.setName("Italian");
		c.add(cat);
		ing.setName("cheese");
		i.add(ing);
		recipe1.setDirections("put stuff on crust, cook it");
		recipe1.setTitle("Pepperoni Pizza");
		recipe1.setCategories(c);
		//recipe1.setIngredients(i);
		
		recipeList.add(recipe1);
		
		Recipe recipe2 = new Recipe();
		Category cat2 = new Category();
		Ingredient ing2 = new Ingredient();
		cat2.setName("Snack");
		ArrayList<Category> c2 = new ArrayList<Category>();
		ArrayList<Ingredient> i2 = new ArrayList<Ingredient>();
		c2.add(cat2);
		ing2.setName("corn");
		i2.add(ing2);
		recipe2.setDirections("heat it up, and pop it");
		recipe2.setTitle("Pop corn");
		recipe2.setCategories(c2);
		//recipe2.setIngredients(i2);
		
		recipeList.add(recipe2);
		resultList.add(recipe2);
	    
	    assertEquals(resultList, searchSort.searchByCategory("Snack", recipeList));
	}
	
	@Test
	public void testSearchByIngredient() 
	{
		//creates two recipes puts them in an arraylist to be passed into method
		//creates another arraylist to hold expected result of search
		ArrayList<Recipe>recipeList = new ArrayList<Recipe>();
		ArrayList<Recipe>resultList = new ArrayList<Recipe>();
		Category cat = new Category();
		ArrayList<Category> c = new ArrayList<Category>();
		Ingredient ing = new Ingredient();
		ArrayList<RecipeManager> rm = new ArrayList<RecipeManager>();
		RecipeManager recipemngr = new RecipeManager();
		
		Recipe recipe1 = new Recipe();
		cat.setName("Italian");
		c.add(cat);
		ing.setName("cheese");
		
		recipe1.setDirections("put stuff on crust, cook it");
		recipe1.setTitle("Pepperoni Pizza");
		recipe1.setCategories(c);
		recipemngr.setIngredient(ing);
		rm.add(recipemngr);
		recipe1.setIngredientsOfRecipe(rm);
		
		recipeList.add(recipe1);
		
		
		Recipe recipe2 = new Recipe();
		Category cat2 = new Category();
		Ingredient ing2 = new Ingredient();
		cat2.setName("Snack");
		ArrayList<Category> c2 = new ArrayList<Category>();
		
		c2.add(cat2);
		ArrayList<RecipeManager> rm2 = new ArrayList<RecipeManager>();
		RecipeManager recipemngr2 = new RecipeManager();
		ing2.setName("corn");
		
		recipe2.setDirections("heat it up, and pop it");
		recipe2.setTitle("Pop corn");
		recipe2.setCategories(c2);
		recipemngr2.setIngredient(ing2);
		rm2.add(recipemngr2);
		recipe2.setIngredientsOfRecipe(rm2);
		
		
		recipeList.add(recipe2);
		resultList.add(recipe1);
	    
	    assertEquals(resultList, searchSort.searchByIngredient("cheese", recipeList));
	}
	
	@Test
	public void testFindCategories()
	{
		//creates two recipes puts them in an arraylist to be passed into method
				//creates another arraylist to hold expected result of search
				ArrayList<Recipe>recipeList = new ArrayList<Recipe>();
				ArrayList<String>resultList = new ArrayList<String>();
				Category cat = new Category();
				ArrayList<Category> c = new ArrayList<Category>();
				Ingredient ing = new Ingredient();
		ArrayList<Ingredient> i = new ArrayList<Ingredient>();
				
				Recipe recipe1 = new Recipe();
				cat.setName("Italian");
				c.add(cat);
				ing.setName("cheese");
				i.add(ing);
				recipe1.setDirections("put stuff on crust, cook it");
				recipe1.setTitle("Pepperoni Pizza");
				recipe1.setCategories(c);
				//recipe1.setIngredients(i);
				
				recipeList.add(recipe1);
				resultList.add(cat.getName().toLowerCase());
				
				Recipe recipe2 = new Recipe();
				Category cat2= new Category();
				Ingredient ing2 = new Ingredient();
				cat2.setName("Snack");
				ArrayList<Category> c2 = new ArrayList<Category>();
				ArrayList<Ingredient> i2 = new ArrayList<Ingredient>();
				c2.add(cat2);
				ing2.setName("corn");
				
				i2.add(ing2);
				recipe2.setDirections("heat it up, and pop it");
				recipe2.setTitle("Pop corn");
				recipe2.setCategories(c2);
				//recipe2.setIngredients(i2);
				
				recipeList.add(recipe2);
				resultList.add(cat2.getName().toLowerCase());
				assertEquals(resultList, searchSort.findCategories(recipeList));
	}
	@Test
	public void testSortAlphabetical()
	{
		//creates two recipes puts them in an arraylist to be passed into method
				//creates another arraylist to hold expected result of search
				ArrayList<Recipe>recipeList = new ArrayList<Recipe>();
				ArrayList<Recipe>resultList = new ArrayList<Recipe>();
				Category cat = new Category();
				ArrayList<Category> c = new ArrayList<Category>();
				Ingredient ing = new Ingredient();
		ArrayList<Ingredient> i = new ArrayList<Ingredient>();
				
				Recipe recipe1 = new Recipe();
				cat.setName("Italian");
				c.add(cat);
				ing.setName("cheese");
				i.add(ing);
				recipe1.setDirections("put stuff on crust, cook it");
				recipe1.setTitle("Pepperoni Pizza");
				recipe1.setCategories(c);
				//recipe1.setIngredients(i);
				
				recipeList.add(recipe1);
				
				
				Recipe recipe2 = new Recipe();
				Category cat2 = new Category();
				Ingredient ing2 = new Ingredient();
				cat2.setName("Snack");
				ArrayList<Category> c2 = new ArrayList<Category>();
				ArrayList<Ingredient> i2 = new ArrayList<Ingredient>();
				c2.add(cat2);
				ing2.setName("corn");
				i2.add(ing2);
				recipe2.setDirections("heat it up, and pop it");
				recipe2.setTitle("Pop corn");
				recipe2.setCategories(c2);
				//recipe2.setIngredients(i2);
				
				recipeList.add(recipe2);
				
				Recipe recipe3 = new Recipe();
				Category cat3 = new Category();
				Ingredient ing3 = new Ingredient();
				cat3.setName("Dessert");
				ArrayList<Category> c3 = new ArrayList<Category>();
				ArrayList<Ingredient> i3 = new ArrayList<Ingredient>();
				c3.add(cat3);
				ing3.setName("apples");
				i3.add(ing3);
				recipe3.setDirections("dip apple in caramel, let dry");
				recipe3.setTitle("Caramel Apples");
				recipe3.setCategories(c3);
				//recipe3.setIngredients(i3);
				
				recipeList.add(recipe3);
				resultList.add(recipe3);
				resultList.add(recipe1);
				resultList.add(recipe2);
				assertEquals(resultList, searchSort.sortRecipeAlphabetical(recipeList));
	}
	
	
	
}
