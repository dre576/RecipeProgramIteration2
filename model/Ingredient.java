package model;


import java.util.ArrayList;
import java.util.List;

public class Ingredient {
	private int idIngredient;

	private String ingredientName;

	public Ingredient(){
	}
	public String getName() {
		return ingredientName;
	}

	public void setName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	
	@Override
	public String toString() {
		return getName();
	}

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}
}
