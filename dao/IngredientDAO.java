package model.dao;

import java.util.List;

import model.Ingredient;
import model.database.GenericDAO;

public class IngredientDAO extends GenericDAO {
	public void createIngredient(Ingredient ingredient){
	     create(ingredient);
	}
	
	public void updateIngredient(Ingredient ingredient){
	     update(ingredient);
	}
	
	public void removeIngredient(Ingredient ingredient){
	     remove(ingredient);
	}
	
	public  List<Ingredient> findAll(){
		List<Ingredient> list = findAll("ingredient");
	    return list;
	}
}
