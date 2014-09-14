package model;
import java.util.ArrayList;
import java.util.HashMap;


public class Recipe {
	private int idRecipe;

	private String directions;
	
	private String title;
	
	private ArrayList<Category> categories = new ArrayList<Category>();
	
	private HashMap<Ingredient, String> ingredients = new HashMap<Ingredient, String>();
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTitle();
	}

	public int getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(int i) {
		this.idRecipe = i;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ArrayList<Category> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<Category> categories) {
		this.categories = categories;
	}

	public HashMap<Ingredient, String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(HashMap<Ingredient, String> ingredients) {
		this.ingredients = ingredients;
	}

}
