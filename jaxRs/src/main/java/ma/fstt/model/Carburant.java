package ma.fstt.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carburants")
public class Carburant implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carburant_id")
	private long carburantId;

	@Column(length = 25, nullable = true, name = "nom")
	private String nom;


	@Column(length = 255, nullable = true, name = "description")
	private String description;
	
	@OneToMany(mappedBy = "carburant", fetch = FetchType.LAZY)
	private Collection<HistoCarb> HistoCarbs;


	public Carburant(long id, String nom, String description) {
		super();
		this.carburantId = id;
		this.nom = nom;
		this.description = description;
	}
	
	
	public long getCarburantId() {
		return carburantId;
	}

	public void setCarburantId(long carburantId) {
		this.carburantId = carburantId;
	}

	public Collection<HistoCarb> getHistoCarbs() {
		return HistoCarbs;
	}

	public void setHistoCarbs(Collection<HistoCarb> histoCarbs) {
		HistoCarbs = histoCarbs;
	}

	public Carburant( String nom, String description) {
		super();

		this.nom = nom;
		this.description = description;
	}
	
	public Carburant(long id) {
		super();
		this.carburantId = id;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Carburant [id=" + carburantId + ", nom=" + nom + ", description=" + description + "]";
	}




	
}
