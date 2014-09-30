package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name="category")
public class Category {
	@Id
	@GeneratedValue
	private Long idCategory;

	@Column(name="categoryName")
	private String categoryName;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinTable(name = "recipe_category",  
	joinColumns = { @JoinColumn(name = "idCategory",  
	updatable =  false) }, inverseJoinColumns = {  
	@JoinColumn(name = "idRecipe", updatable = false) })
	private List<Recipe> recipes = new ArrayList<Recipe>();

	public Category(){
		recipes = new ArrayList<Recipe>();
	}
	
	public Long getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(Long idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
