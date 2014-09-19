package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity(name="recipe")
public class Recipe {
	@Id
	@GeneratedValue
	private Long idRecipe;

	@Column(name="directions", length = 255)
	private String directions;

	@Column(name="title")
	private String title;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)  
	@JoinTable(name = "recipe_category",  
	joinColumns = { @JoinColumn(name = "idRecipe",  
	updatable =  false) }, inverseJoinColumns = {  
	@JoinColumn(name = "idCategory", updatable = false) })
	private List<Category> categories;
	
	@OneToMany(mappedBy="recipe", cascade = CascadeType.ALL)	
	private List<Ingredient> ingredients;
	
	public Recipe (){
		categories = new ArrayList<Category>();
		ingredients = new ArrayList<Ingredient>();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getTitle();
	}

	public Long getIdRecipe() {
		return idRecipe;
	}

	public void setIdRecipe(Long idRecipe) {
		this.idRecipe = idRecipe;
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}	
}
