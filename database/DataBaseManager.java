package model.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Category;
import model.Ingredient;
import model.Recipe;

public class DataBaseManager {
	private static EntityManagerFactory emf = null;
	private static EntityManager em = null;
	
	
	private final Class<?>[] CLASSES = new Class<?>[]{
			Recipe.class,
			Category.class,
			Ingredient.class
			};

	
	private DataBaseManager(){
		emf = DynamicPersistenceUnits.createEMF(CLASSES, "localhost", "3306" , "recipe", "root", "root");
		em = emf.createEntityManager();
		}
	
	synchronized static EntityManagerFactory getManagerFactory() {
		if(emf==null)
			new DataBaseManager();		
		return emf;
	}
	
	public static EntityManager getDataBaseSession(){
		if(em==null)
			em = getManagerFactory().createEntityManager();
		return em;
	}

	public static EntityManager getEm() {
		return em;
	}

	public static void setEm(EntityManager em) {
		DataBaseManager.em = em;
	}

}
