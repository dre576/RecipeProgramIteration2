package controller;

import model.Category;
import model.Ingredient;
import model.dao.CategoryDAO;
import model.dao.IngredientDAO;

public class CategoryController {
	public static void saveCategory(Category category) {
		try {
			if (category.getIdCategory() == null) {
				CategoryDAO.createCategory(category);
			} else {
				CategoryDAO.updateCategory(category);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Category getCategory(String nameCategory) {
		Category category = null;
		
		for (Category c : CategoryDAO.findAll()) {
			if(c.getName().compareTo(nameCategory.toUpperCase()) == 0){
				category = c;
				break;
			}
		}
		
		if (category == null){
			category = new Category();
			category.setName(nameCategory);
			CategoryController.saveCategory(category);
			return category;
		} else return category;
	}

}
