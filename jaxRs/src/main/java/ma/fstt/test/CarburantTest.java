package ma.fstt.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.fstt.model.Carburant;
import ma.fstt.persistence.CarburantOperations;

public class CarburantTest {

	public static void main(String[] args) {
		
	
		
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Carburant s=new Carburant("test1", "test1");
		em.persist(s);
		em.getTransaction().commit();
	}

}
