package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name="ingredient")
public class Ingredient {
	@Id
	@GeneratedValue
	private Long idIngredient;

	@Column(name="ingredientName")
	private String ingredientName;
	
	@OneToMany(mappedBy = "ingredient")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<RecipeManager> ingredientsOfRecipe = new ArrayList<RecipeManager>();	
	
	public Long getIdIngredient() {
		return idIngredient;
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

	public List<RecipeManager> getIngredientsOfRecipe() {
		return ingredientsOfRecipe;
	}

	public void setIngredientsOfRecipe(List<RecipeManager> ingredientsOfRecipe) {
		this.ingredientsOfRecipe = ingredientsOfRecipe;
	}
}
