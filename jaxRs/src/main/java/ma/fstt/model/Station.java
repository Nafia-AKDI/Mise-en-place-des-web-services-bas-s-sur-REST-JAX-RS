package ma.fstt.model;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Etudiant
 *
 */
@Entity
@Table(name = "stations")
public class Station implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "station_id")
	private int stationId;
	@Column(length = 25, nullable = true, name = "nom")
	private String nom;
	@Column(length = 25, nullable = true, name = "ville")
	private String ville;
	@Column(length = 50, nullable = true, name = "adresse")
	private String adresse;
	
	@OneToMany(mappedBy = "station", fetch = FetchType.LAZY)
	private Collection<HistoCarb> HistoCarbs;


	public Station() {
		super();
	}


	public int getStationId() {
		return stationId;
	}


	public void setStationId(int stationId) {
		this.stationId = stationId;
	}


	public Collection<HistoCarb> getHistoCarbs() {
		return HistoCarbs;
	}


	public void setHistoCarbs(Collection<HistoCarb> histoCarbs) {
		HistoCarbs = histoCarbs;
	}


	public Station(int id, String nom, String ville, String adresse) {
		super();
		this.stationId = id;
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
	}

	public Station( String nom, String ville, String adresse) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.adresse = adresse;
	}
	
	public Station(int id) {
		super();
		this.stationId = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getAdresse() {
		return adresse;
	}


	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Station [id=" + stationId + ", nom=" + nom + ", ville=" + ville + ", adresse=" + adresse + "]";
	}

	
}