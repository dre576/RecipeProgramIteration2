package model.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.HibernateException;


import java.util.List;

public class GenericDAO {	
	EntityManager em = DataBaseManager.getDataBaseSession();
	protected void create (Object object)
	{
		
		EntityTransaction transaction = null;
		try{
			transaction = em.getTransaction();
			transaction.begin();
			em.persist(object);
			transaction.commit();
		} catch (HibernateException e){
			System.out.println("It was not possible to insert the object: " + e.getMessage());
		} finally{
			try{
			//	em.close();
			} catch (Throwable e){
				System.out.println("Error while closing insert operation. Message: " + e.getMessage());
			}
		}
	}
	
	protected void update (Object object)
	{
		EntityTransaction transaction = null;
		try{
			transaction = em.getTransaction();
			transaction.begin();
			em.merge(object);
			transaction.commit();
		} catch (HibernateException e){
			System.out.println("It was not possible to change the objcet. Error: "+e.getMessage());
		} finally {
			try{
				//em.close();
			} catch (Throwable e){
				System.out.println("Error while closing update operation. Message: " +e.getMessage());
			}
		}
	}
	
	protected void remove (Object object)
	{
		EntityTransaction transaction = null;
		try{
			transaction = em.getTransaction();
			transaction.begin();
			em.remove(object);
			transaction.commit();
		} catch (HibernateException e){
			System.out.println("It was not possible to remove the object: "+e.getMessage());
		} finally {
			try{
			//	em.close();
			} catch (Throwable e){
				System.out.println("Error while closing remove operation. Message: "+e.getMessage());
			}
		}
	}
	
	protected List findAll (String entity)
	{
		List<Object> result = null;
		EntityTransaction transaction = null;
		try{
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
					//em.close();
			} catch (Throwable e){
				System.out.println("Error while closing operation. Message: "+e.getMessage());
			}
		}
	}
}
