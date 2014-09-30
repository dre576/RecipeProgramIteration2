package model.dao;

import java.util.List;

import model.Ingredient;
import model.database.GenericDAO;

public class IngredientDAO extends GenericDAO {
	public static void createIngredient(Ingredient ingredient){
	     create(ingredient);
	}
	
	public static void updateIngredient(Ingredient ingredient){
	     update(ingredient);
	}
	
	public static void removeIngredient(Ingredient ingredient){
	     remove(ingredient);
	}
	
	public  static List<Ingredient> findAll(){
		List<Ingredient> list = findAll("ingredient");
	    return list;
	}
}
