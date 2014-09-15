import java.util.ArrayList;

import model.Recipe;
import model.Category;
import model.Ingredient;
import controller.searchSort;
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
		
		Recipe recipe1 = new Recipe();
		cat.setName("Italian");
		c.add(cat);
		ing.setName("cheese");
		recipe1.setDirections("put stuff on crust, cook it");
		recipe1.setTitle("Pepperoni Pizza");
		recipe1.setCategories(c);
		recipe1.getIngredients().put(ing, "5");
		
		recipeList.add(recipe1);
		resultList.add(recipe1);
		
		Recipe recipe2 = new Recipe();
		Category cat2 = new Category();
		Ingredient ing2 = new Ingredient();
		cat2.setName("Snack");
		ArrayList<Category> c2 = new ArrayList<Category>();
		c2.add(cat);
		ing2.setName("corn");
		recipe2.setDirections("heat it up, and pop it");
		recipe2.setTitle("Pop corn");
		recipe2.setCategories(c2);
		recipe2.getIngredients().put(ing2, "2");
		
		recipeList.add(recipe2);
	    
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
		
		Recipe recipe1 = new Recipe();
		cat.setName("Italian");
		c.add(cat);
		ing.setName("cheese");
		recipe1.setDirections("put stuff on crust, cook it");
		recipe1.setTitle("Pepperoni Pizza");
		recipe1.setCategories(c);
		recipe1.getIngredients().put(ing, "5");
		recipeList.add(recipe1);
		
		Recipe recipe2 = new Recipe();
		Category cat2 = new Category();
		Ingredient ing2 = new Ingredient();
		cat2.setName("Snack");
		ArrayList<Category> c2 = new ArrayList<Category>();
		c2.add(cat2);
		ing2.setName("corn");
		recipe2.setDirections("heat it up, and pop it");
		recipe2.setTitle("Pop corn");
		recipe2.setCategories(c2);
		recipe2.getIngredients().put(ing2, "2");
		
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
		
		Recipe recipe1 = new Recipe();
		cat.setName("Italian");
		c.add(cat);
		ing.setName("cheese");
		recipe1.setDirections("put stuff on crust, cook it");
		recipe1.setTitle("Pepperoni Pizza");
		recipe1.setCategories(c);
		recipe1.getIngredients().put(ing, "5");
		recipeList.add(recipe1);
		
		Recipe recipe2 = new Recipe();
		Category cat2 = new Category();
		Ingredient ing2 = new Ingredient();
		cat2.setName("Snack");
		ArrayList<Category> c2 = new ArrayList<Category>();
		c2.add(cat2);
		ing2.setName("corn");
		recipe2.setDirections("heat it up, and pop it");
		recipe2.setTitle("Pop corn");
		recipe2.setCategories(c2);
		recipe2.getIngredients().put(ing2, "2");
		
		recipeList.add(recipe2);
		resultList.add(recipe1);
	    
	    assertEquals(resultList, searchSort.searchByIngredient("cheese", recipeList));
	}
	
}
