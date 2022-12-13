package ma.fstt.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Histo_carb")
public class HistoCarb implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private long id;

	@Column(nullable = true, name= "prix")
	private int prix;
	
	@Column(nullable = true, name= "date")
	private Date date;
	
	
	public HistoCarb(long id, int prix, Date date, Carburant carburant, Station station) {
		super();
		this.id = id;
		this.prix = prix;
		this.date = date;
		this.carburant = carburant;
		this.station = station;
	}
	
	public HistoCarb() {
		super();
	}
	
	public HistoCarb( int prix, Date date, Carburant carburant, Station station) {
		super();
		this.prix = prix;
		this.date = date;
		this.carburant = carburant;
		this.station = station;
	}
	
	public HistoCarb(long id) {
		super();
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name= "carburant_id")
	private Carburant carburant;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Carburant getCarburant() {
		return carburant;
	}

	public void setCarburant(Carburant carburant) {
		this.carburant = carburant;
	}

	public Station getStation() {
		return station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "HistoCarb [id=" + id + ", prix=" + prix + ", date=" + date + ", carburant=" + carburant + ", station="
				+ station + "]";
	}

	@ManyToOne
	@JoinColumn(name= "station_id")
	private Station station;

	
}
