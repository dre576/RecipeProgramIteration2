package model.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;

import model.Category;
import model.Ingredient;
import model.Recipe;
import model.RecipeManager;

public class DataBaseManager {
	private static EntityManagerFactory emf = null;
	
	
	private final Class<?>[] CLASSES = new Class<?>[]{
			Recipe.class,
			Category.class,
			Ingredient.class,
			RecipeManager.class
			};

	
	private DataBaseManager(){
		try{
			emf = DynamicPersistenceUnits.createEMF(CLASSES, "localhost", "3306" , "recipe", "root", "root");
			}
		
		catch(Exception exception)
		{
			JOptionPane.showMessageDialog(null, "Error connecting to database.", "Database error.", JOptionPane.ERROR_MESSAGE);
		}
		}
	
	synchronized static EntityManagerFactory getManagerFactory() {
		if(emf==null)
			new DataBaseManager();		
		return emf;
	}
	
	public static EntityManager getDataBaseSession(){
		return getManagerFactory().createEntityManager();
	}
}
