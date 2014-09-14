package view;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import controller.ReadFile;
import controller.WriteFile;
import controller.searchSort;

import model.Category;
import model.Ingredient;
import model.Recipe;

public class Main {
	public static void main(String[] args) {		
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
		ArrayList<Category> categories = new ArrayList<Category>();

		ingredients = ReadFile.getIngredients();
		categories = ReadFile.getCategories();
		recipes = ReadFile.getRecipes();

		int answer;
		do {
			answer = Integer.parseInt(JOptionPane.showInputDialog(
							"1 - Create recipe."
							+ "\n2- Update recipe."
							+ "\n3 - Remove recipe."
							+ "\n4 - See recipes."
							+ "\n5 - Search by Category."
							+ "\n6 - Search by Ingredient."
							+ "\n7 - Search by Name."
							+ "\n8 - Sort recipes in alphabetical order."
							+ "\n9 - Find categories. "
							+ "\n10 - See ingredients and the recipes where they are being used."
							+ "\n11 - See categories and the recipes where they are being used."
							+ "\n12 - Exit."));
			
			switch (answer) {
			case 1:
				Recipe recipe = new Recipe();

				
				String name = JOptionPane.showInputDialog("What's the name of the recipe?");
				recipe.setTitle(name);
				String directions = JOptionPane.showInputDialog("What are the directions of the recipe?");
				recipe.setDirections(directions);

				
				int howManyIngredients = Integer.parseInt(JOptionPane.showInputDialog("How many ingrediens do the recipe have?"));
				for (int i = 0; i < howManyIngredients; i++) {					
					String nameIngredient = JOptionPane.showInputDialog("What's the name of the ingredient?");					
					String amountIngredient = JOptionPane.showInputDialog("What's the amount of the ingredient?");
					for (Ingredient ingr : ingredients) {
						if (ingr.getName().toLowerCase().contains(nameIngredient.toLowerCase())
								|| nameIngredient.toLowerCase().contains(ingr.getName().toLowerCase())) {
							recipe.getIngredients().put(ingr, amountIngredient);
						} else {
							Ingredient ingredient = new Ingredient();
							ingredient.setName(nameIngredient);
							recipe.getIngredients().put(ingredient,
									amountIngredient);

						}
					}
				}
				
				int howManyCategories = Integer.parseInt(JOptionPane.showInputDialog("How many categories do the recipe have?"));
				for (int i = 0; i < howManyCategories; i++) {					
					String nameCategory = JOptionPane.showInputDialog("What's the name of the category?");
					for (Category categ : categories) {
						if (categ.getName().toLowerCase().contains(nameCategory.toLowerCase()) 
								|| nameCategory.toLowerCase().contains(categ.getName().toLowerCase())) {
							recipe.getCategories().add(categ);
						} else {
							Category category = new Category();
							category.setName(nameCategory);
							recipe.getCategories().add(category);

						}
					}
				}
				recipes.add(recipe);
				WriteFile.saveFile(recipes);
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"It would be just to big to do this in the command line, so I'll wait"
								+ "for the GUI to be ready and I can work on that with Nickel");
				break;
			case 3:
				String options = "";
				for (int i = 0; i < recipes.size(); i++) {
					options += (i + 1) + " - "
							+ recipes.get(i).getTitle() +"\n";
				}
				JOptionPane.showMessageDialog(null, options);
				int recipeChosen = Integer.parseInt(JOptionPane.showInputDialog("Which recipe do you want to remove?"));
				recipes.remove(recipes.get(recipeChosen - 1));
				WriteFile.saveFile(recipes);
				break;

			case 4:
				String print = "";
				print = "----------------------------\n";
				for (Recipe r : recipes) {
					print += "Title: " + r.getTitle() + "\n";
					print += "Ingredients: " + "\n";
					Iterator iterator = r.getIngredients().entrySet()
							.iterator();
					while (iterator.hasNext()) {
						Map.Entry pairs = (Map.Entry) iterator.next();
						print += pairs.getKey() + ": "
								+ pairs.getValue() + "\n";
					}
					print += "Category(ies): " + "\n";
					for (Category c : r.getCategories()) {
						print += c + "\n";
					}
					print += "Directions: " + r.getDirections() + "\n";
					print += "----------------------------" + "\n";
				}
				JOptionPane.showMessageDialog(null, print);
				break;
			case 5:				
				String searchedStringCategory = JOptionPane.showInputDialog(null, "What's the searched string?");
				JOptionPane.showMessageDialog(null, searchSort.searchByCategory(
						searchedStringCategory, recipes));
				break;
			case 6:
				String searchedStringIngredient = JOptionPane.showInputDialog(null, "What's the searched string?");
				JOptionPane.showMessageDialog(null, searchSort.searchByIngredient(
						searchedStringIngredient, recipes));
				break;
			case 7:
				String searchedStringName = JOptionPane.showInputDialog(null, "What's the searched string?");
				JOptionPane.showMessageDialog(null, searchSort.searchByName(searchedStringName,
						recipes));
				break;
			case 8:
				JOptionPane.showMessageDialog(null, searchSort.sortRecipeAlphabetical(recipes));
				break;
			case 9:
				JOptionPane.showMessageDialog(null, searchSort.findCategories(recipes));
				break;
			case 10:
				JOptionPane.showMessageDialog(null, searchSort.getIngredientsRecipes(recipes));
				break;
			case 11:
				JOptionPane.showMessageDialog(null, searchSort.getCategoriesRecipes(recipes));
				break;
			case 12: System.exit(0);

			}
		} while (answer < 13 && answer > 0);
	}
}
