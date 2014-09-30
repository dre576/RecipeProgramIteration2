package model.dao;

import java.util.List;

import model.Category;
import model.database.GenericDAO;

public class CategoryDAO extends GenericDAO {
	public static void createCategory(Category category){
	     create(category);
	}
	
	public static void updateCategory(Category category){
	     update(category);
	}
	
	public static void removeCategory(Category category){
	     remove(category);
	}
	
	public static List<Category> findAll(){
		List<Category> list = findAll("category");
	    return list;
	}
}
