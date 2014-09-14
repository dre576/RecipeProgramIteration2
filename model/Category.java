package model;


import java.util.ArrayList;
import java.util.List;

public class Category {
	private int idCategory;

	private String categoryName;
	
	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	@Override
	public String toString() {
		return getName();
	}
}
