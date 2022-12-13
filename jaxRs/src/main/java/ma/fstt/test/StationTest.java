package ma.fstt.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ma.fstt.model.Station;
import ma.fstt.persistence.StationOperations;

public class StationTest {

	public static void main(String[] args) {
		
	
	
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("unit");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Station s=new Station( "test1", "test1", "test1");
		em.persist(s);
		em.getTransaction().commit();
	}

}
