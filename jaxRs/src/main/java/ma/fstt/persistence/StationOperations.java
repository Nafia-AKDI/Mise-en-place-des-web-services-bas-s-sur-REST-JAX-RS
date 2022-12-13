package ma.fstt.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import ma.fstt.model.Station;

public class StationOperations {
	private static final String PERSISTENCE_UNIT_NAME = "unit";
	private static EntityManager entityMgrObj = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
			.createEntityManager();
	private static EntityTransaction transactionObj = entityMgrObj.getTransaction();

	@SuppressWarnings("unchecked")
	public List<Station> getAllStations() {
		Query queryObj = entityMgrObj.createQuery("SELECT p FROM Station p");
		List<Station> stations = queryObj.getResultList();
		if (stations != null && stations.size() > 0) {
			return stations;
		} else {
			return null;
		}
	}

	public Station findStation(Long id) {
		Station station = entityMgrObj.find(Station.class, id);
		entityMgrObj.refresh(station);
		if (station != null) {
			return station;
		} else {
			return null;
		}
	}

	public String persistStation(Station station) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(station)) {
			station = entityMgrObj.merge(station);
		}
		entityMgrObj.persist(station);
		transactionObj.commit();
		return "true";
	}

	public String updateStation(Station station) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		Station newStation = entityMgrObj.find(Station.class, station.getStationId());
		newStation.setNom(station.getNom());
		newStation.setVille(station.getVille());
		newStation.setAdresse(station.getAdresse());
		
		transactionObj.commit();
		return "true";
	}

	public String deleteProduct(Station station) {
		if (!transactionObj.isActive()) {
			transactionObj.begin();
		}
		if (!entityMgrObj.contains(station)) {
			station = entityMgrObj.merge(station);
		}
		entityMgrObj.remove(station);
		transactionObj.commit();
		return "true";
	}
}