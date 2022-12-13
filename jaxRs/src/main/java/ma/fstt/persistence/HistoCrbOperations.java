package ma.fstt.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.HistoCarb;
import ma.fstt.model.Carburant;
import ma.fstt.model.Station;

public class HistoCrbOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	@SuppressWarnings("unchecked")
	public List<HistoCarb> getHistoCarb() {
		Query queryObj = entityMgrObj.createQuery("SELECT p FROM Histo_carb p");
		List<HistoCarb> histoCarbs = queryObj.getResultList();
		if (histoCarbs != null && histoCarbs.size() > 0) {
			return histoCarbs;
		} else {
			return null;
		}
	}
	
	public String persistHistoCarb(HistoCarb histoCarbs) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(histoCarbs)) {
			histoCarbs = entityMgrObj.merge(histoCarbs);
		}
		entityMgrObj.persist(histoCarbs);
		transactionObj.commit();
		return "true";
	}
	public HistoCarb findHistoCarb(Long id) {
		HistoCarb histoCarb = entityMgrObj.find(HistoCarb.class, id);
		entityMgrObj.refresh(histoCarb);
		if (histoCarb != null) {
			return histoCarb;
		} else {
			return null;
		}
	}

	public String addToHistoCarb(HistoCarb histoCarb) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(histoCarb)) {
			histoCarb = entityMgrObj.merge(histoCarb);
		}
		entityMgrObj.persist(histoCarb);
		transactionObj.commit();
		return "true";
	}

	

	public String deleteFromHisto(HistoCarb histoCarb) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(histoCarb)) {
			histoCarb = entityMgrObj.merge(histoCarb);
		}
		entityMgrObj.remove(histoCarb);
		transactionObj.commit();
		return "true";
	}
	

	
	public String deleteHistoCarb(HistoCarb histoCarb) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(histoCarb)) {
			histoCarb = entityMgrObj.merge(histoCarb);
		}
		entityMgrObj.remove(histoCarb);
		transactionObj.commit();
		return "true";
	}
}
