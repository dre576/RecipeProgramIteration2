package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ingredient")
public class Ingredient {
	@Id
	@GeneratedValue
	private Long idIngredient;

	@Column(name="ingredientName")
	private String ingredientName;

	@Column(name="amount")
	private String amount;	
	
	@ManyToOne
	@JoinColumn(name = "recipe")
	private Recipe recipe;	
	
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
