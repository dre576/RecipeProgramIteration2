package model.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;


import java.util.List;

public class GenericDAO {	
	protected static void create (Object object)
	{
		
		EntityTransaction transaction = null;
		EntityManager em = null;
		try{
			em = DataBaseManager.getDataBaseSession();
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(object);
			transaction.commit();
		} catch (HibernateException e){
			System.out.println("It was not possible to insert the object: " + e.getMessage());
		} finally{
			try{
				em.close();
			} catch (Throwable e){
				e.printStackTrace();
			}
		}
	}
	
	protected static void update (Object object)
	{
		EntityTransaction transaction = null;
		EntityManager em = null;
		try{
			em = DataBaseManager.getDataBaseSession();
			transaction = em.getTransaction();
			transaction.begin();
			em.merge(object);
			transaction.commit();
		} catch (HibernateException e){
			System.out.println("It was not possible to change the objcet. Error: "+e.getMessage());
		} finally {
			try{
				em.close();
			} catch (Throwable e){
				System.out.println("Error while closing update operation. Message: " +e.getMessage());
			}
		}
	}
	
	protected static void remove (Object object)
	{
		EntityTransaction transaction = null;
		EntityManager em = null;
		try{
			em = DataBaseManager.getDataBaseSession();
			transaction = em.getTransaction();
			transaction.begin();
			em.remove(em.contains(object)? object:em.merge(object));
			transaction.commit();
		} catch (HibernateException e){
			System.out.println("It was not possible to remove the object: "+e.getMessage());
		} finally {
			try{
				em.close();
			} catch (Throwable e){
				System.out.println("Error while closing remove operation. Message: "+e.getMessage());
			}
		}
	}
	
	protected static List findAll (String entity)
	{
		List<Object> result = null;
		EntityTransaction transaction = null;
		EntityManager em = null;
		try{
			em = DataBaseManager.getDataBaseSession();
			transaction = em.getTransaction();
			transaction.begin();
			result = em.createQuery("FROM "+entity).getResultList();
			transaction.commit();
			return result;				
		} catch(HibernateException e){
			System.out.println("It was not possible to select all objects: " +e.getMessage());
			throw new HibernateException(e);
		} finally{
			try{
					em.close();
			} catch (Throwable e){
				System.out.println("Error while closing operation. Message: "+e.getMessage());
			}
		}
	}
}
