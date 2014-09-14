package controller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import model.Category;
import model.Ingredient;
import model.Recipe;

import com.thoughtworks.xstream.XStream;

public class ReadFile {
	FileReader fileReader = null;
	static ArrayList<Recipe> recipes;
	
	public static void readFile() {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("myFile.xml");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  
		XStream xstream2 = new XStream();     
		xstream2.alias("Recipes", List.class);   
		recipes =  (ArrayList<Recipe>) xstream2.fromXML(fileReader);
	}
	
	public static ArrayList<Recipe> getRecipes() {
		if(recipes == null)
			readFile();
		return recipes;
	}
	
	public static ArrayList<Ingredient> getIngredients() {
		if(recipes == null)
			readFile();
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		for (Recipe recipe : recipes) {
			Iterator it = recipe.getIngredients().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pairs = (Map.Entry)it.next();
		        if(!ingredients.contains(pairs.getKey())){
		        	ingredients.add((Ingredient) pairs.getKey());
		        }
		    }
		}
		return ingredients;
	}
	
	public static HashMap<Ingredient, ArrayList<Recipe>> getIngredientsRecipes() {
		if(recipes == null)
			readFile();
		HashMap<Ingredient, ArrayList<Recipe>> ingredientsRecipes = new HashMap<Ingredient, ArrayList<Recipe>>();
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		for (Recipe recipe : recipes) {
			Iterator it = recipe.getIngredients().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pairs = (Map.Entry)it.next();
		        if(ingredientsRecipes.containsKey(pairs.getKey())){
		        	ingredientsRecipes.get(pairs.getKey()).add(recipe);
		        	//ingredientsRecipes.put(pairs.getKey(), );
		        } else {
		        	ArrayList<Recipe> list = new ArrayList<Recipe>();
		        	list.add(recipe);
		        	ingredientsRecipes.put((Ingredient) pairs.getKey(), list);
		        }
		    }
		}
		return ingredientsRecipes;
	}

	public static HashMap<Category, ArrayList<Recipe>> getCategoriesRecipes() {
		if(recipes == null)
			readFile();
		HashMap<Category, ArrayList<Recipe>> ingredientsCategories = new HashMap<Category, ArrayList<Recipe>>();
		ArrayList<Category> categories = new ArrayList<Category>();
		for (Recipe recipe : recipes) {
			for (Category category : recipe.getCategories()) {
				 if(ingredientsCategories.containsKey(category)){
					 ingredientsCategories.get(category).add(recipe);
			        } else {
			        	ArrayList<Recipe> list = new ArrayList<Recipe>();
			        	list.add(recipe);
			        	ingredientsCategories.put(category, list);
			        }
			}
		}
		
		return ingredientsCategories;
	}
	
	public static ArrayList<Category> getCategories() {
		if(recipes == null)
			readFile();
		ArrayList<Category> categories = new ArrayList<Category>();
		for (Recipe recipe : recipes) {
			for (Category category : recipe.getCategories()) {
				if(!categories.contains(category)){
					categories.add(category);
				}
			}
		}
		return categories;
	}
}
