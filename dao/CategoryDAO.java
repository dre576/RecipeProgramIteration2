package model.dao;

import java.util.List;

import model.Category;
import model.database.GenericDAO;

public class CategoryDAO extends GenericDAO {
	public void createCategory(Category category){
	     create(category);
	}
	
	public void updateCategory(Category category){
	     update(category);
	}
	
	public void removeCategory(Category category){
	     remove(category);
	}
	
	public  List<Category> findAll(){
		List<Category> list = findAll("category");
	    return list;
	}
}
