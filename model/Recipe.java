package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;

@Entity(name= "recipe")
public class Recipe {
	@Id
	@GeneratedValue
	private Long idRecipe;

	@Column(name="directions")
	@Type(type="text")
	private String directions;

	@Column(name="title")
	private String title;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "recipe_category",  
	joinColumns = { @JoinColumn(name = "idRecipe",  
	updatable =  false) }, inverseJoinColumns = {  
	@JoinColumn(name = "idCategory", updatable = false) })
	private List<Category> categories;
	
	@OneToMany(mappedBy="recipe")
	@Cascade( value = org.hibernate.annotations.CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<RecipeManager> ingredientsOfRecipe;
	
	public Recipe (){
		categories = new ArrayList<Category>();
		ingredientsOfRecipe = new ArrayList<RecipeManager>();
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

	public void setIngredient(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public List<RecipeManager> getIngredientsOfRecipe() {
		return ingredientsOfRecipe;
	}

	public void setIngredientsOfRecipe(List<RecipeManager> ingredientsOfRecipe) {
		this.ingredientsOfRecipe = ingredientsOfRecipe;
	}

	public HashMap<String, String> getIngredients() {
		HashMap<String, String> ingredients = new HashMap<String, String>();
		for (RecipeManager i : ingredientsOfRecipe) {
			ingredients.put(i.getIngredient().getName(), i.getAmount());
		}
		return ingredients;
	}

	public String getVisualText() {
		String text = "";
		text = text + "<b><span style=\"font-family: Georgia, Times New Roman, serif; font-size: x-large;\">"+getTitle()+"</span></b><br />";
		text = text + "<br />";
		text = text + "<span style=\"font-family: Helvetica Neue, Arial, Helvetica, sans-serif; font-size: large;\"><i>";
		
		Iterator it = getIngredients().entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			String nameIngredient = (String)pairs.getKey();
			String amountIngredient = (String)pairs.getValue();
			text = text + nameIngredient + " " + amountIngredient;
			text = text + "<br />";
			it.remove(); 
		}
		text = text + "</i></span><br />";
		text = text + "<span style=\"font-family: Times, Times New Roman, serif; font-size: large;\"><b>";
		for (Category category : getCategories()) {
			text = text + category;
			text = text + "<br />";
		}
		text = text + "</b></span><br />";
		text = text + "<br />";
		text = text + "<div style=\"text-align: justify;\">";
		text = text + "<span style=\"font-family: Times, Times New Roman, serif; font-size: large;\">"+getDirections()+"</span></div>";
		return text;
	}

}
