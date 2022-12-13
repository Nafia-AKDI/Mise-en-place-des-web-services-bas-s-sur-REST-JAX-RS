package ma.fstt.persistence;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.Carburant;

public class CarburantOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	@SuppressWarnings("unchecked")
	public List<Carburant> getAllCarburants() {
		Query queryObj = entityMgrObj.createQuery("SELECT p FROM Carburant p");
		List<Carburant> carburants = queryObj.getResultList();
		if (carburants != null && carburants.size() > 0) {
			return carburants;
		} else {
			return null;
		}
	}

	public Carburant findCarburant(Long id) {
		Carburant carburant = entityMgrObj.find(Carburant.class, id);
		entityMgrObj.refresh(carburant);
		if (carburant != null) {
			return carburant;
		} else {
			return null;
		}
	}

	public String persistCarburant(Carburant carburant) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(carburant)) {
			carburant = entityMgrObj.merge(carburant);
		}
		entityMgrObj.persist(carburant);
		transactionObj.commit();
		return "true";
	}

	public String updateCarburant(Carburant carburant) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		Carburant newCarburant = entityMgrObj.find(Carburant.class, carburant.getCarburantId());
		newCarburant.setNom(carburant.getNom());
		newCarburant.setDescription(carburant.getDescription());
		
		transactionObj.commit();
		return "true";
	}

	public String deleteCarburant(Carburant carburant) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(carburant)) {
			carburant = entityMgrObj.merge(carburant);
		}
		entityMgrObj.remove(carburant);
		transactionObj.commit();
		return "true";
	}
}
