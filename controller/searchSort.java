package controller;

import model.Category;
import model.Ingredient;
import model.Recipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class searchSort {
	//NEED to check which recipe importing
	
	public static ArrayList<Recipe> searchByName(String searchedString,
			ArrayList<Recipe> recipeArray) {

		ArrayList<Recipe> foundRecipesArray = new ArrayList<Recipe>();
		for (Recipe recipe : recipeArray) {
			if (recipe.getTitle().toLowerCase()
					.contains(searchedString.toLowerCase())) {
				foundRecipesArray.add(recipe);
			}
		}

		return foundRecipesArray;

	}

	public static ArrayList<Recipe> searchByIngredient(String searchedString,
			ArrayList<Recipe> recipeArray) {

		ArrayList<Recipe> foundRecipesArray = new ArrayList<Recipe>();
		for (Recipe recipe : recipeArray) {
			for (Ingredient ingredient : recipe.getIngredients()) {
				if (ingredient.getName().toLowerCase().contains(searchedString.toLowerCase())) {
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
				if (category.getName().toLowerCase().contains(searchedString.toLowerCase())) {
					foundRecipesArray.add(recipe);
					break;
				}
			}
		}

		return foundRecipesArray;

	}

	public static ArrayList<String> findCategories(ArrayList<Recipe> recipeArray) {
		ArrayList<String> categorySet = new ArrayList<String>();
        for (Recipe r : recipeArray) {
            for (Category i : r.getCategories()) {
                categorySet.add(i.getName().toLowerCase());
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

}
