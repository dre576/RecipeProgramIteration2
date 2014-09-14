package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

import model.Category;
import model.Ingredient;
import model.Recipe;

public class searchSort {
	
	public static ArrayList<Recipe> searchByName(String searchedString,
			ArrayList<Recipe> recipeArray) {

		ArrayList<Recipe> foundRecipesArray = new ArrayList<Recipe>();
		for (Recipe recipe : recipeArray) {
			if (recipe.getTitle().toLowerCase().contains(searchedString.toLowerCase()) 
					|| searchedString.toLowerCase().contains(recipe.getTitle().toLowerCase())) {
				foundRecipesArray.add(recipe);
			}
		}

		return foundRecipesArray;

	}

	public static ArrayList<Recipe> searchByIngredient(String searchedString,
			ArrayList<Recipe> recipeArray) {

		ArrayList<Recipe> foundRecipesArray = new ArrayList<Recipe>();
		for (Recipe recipe : recipeArray) {
			Iterator it = recipe.getIngredients().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pairs = (Map.Entry)it.next();
		        if (((Ingredient) pairs.getKey()).getName().toLowerCase().contains(searchedString.toLowerCase())
		        		|| searchedString.toLowerCase().contains(((Ingredient) pairs.getKey()).getName().toLowerCase())) {
					foundRecipesArray.add(recipe);
					break;
				}
		    }
		}

		return foundRecipesArray;

	}

	public static ArrayList<Recipe> searchByCategory(String searchedString,
			ArrayList<Recipe> recipeArray) {

		ArrayList<Recipe> foundRecipesArray = new ArrayList<Recipe>();
		for (Recipe recipe : recipeArray) {
			for (Category category : recipe.getCategories()) {
				if (category.getName().toLowerCase().contains(searchedString.toLowerCase())
						|| searchedString.toLowerCase().contains(category.getName().toLowerCase())) {
					foundRecipesArray.add(recipe);
					break;
				}
			}
		}

		return foundRecipesArray;

	}

	public static Set<Category> findCategories(ArrayList<Recipe> recipeArray) {
		Set<Category> categorySet = new HashSet<Category>();
        for (Recipe r : recipeArray) {
            for (Category i : r.getCategories()) {
                categorySet.add(i);
            }
        }
		return categorySet;

	}
	public static ArrayList<Recipe> sortRecipeAlphabetical(
			ArrayList<Recipe> recipeArray) {
		ArrayList<Recipe> alphabeticalList = new ArrayList<Recipe>();

		for (Recipe recipe : recipeArray) {
			alphabeticalList.add(recipe);
		}

		Collections.sort(alphabeticalList, new Comparator<Recipe>() {
			@Override
			public int compare(Recipe o1, Recipe o2) {
				return o1.getTitle().toLowerCase()
						.compareTo(o2.getTitle().toLowerCase());
			}
		});

		return alphabeticalList;
	}
	
	public static HashMap<Ingredient, ArrayList<Recipe>> getIngredientsRecipes(ArrayList<Recipe> recipes) {
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

	public static HashMap<Category, ArrayList<Recipe>> getCategoriesRecipes(ArrayList<Recipe> recipes) {
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

}
