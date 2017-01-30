package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({@NamedQuery(name = "CompteBancaire.findAll", query = "SELECT cb FROM CompteBancaire cb"),@NamedQuery(name = "CompteBancaire.findBYClient", query = "SELECT cb FROM CompteBancaire cb where cb.client=:client")})
public class CompteBancaire implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long rib;
	private double solde;
	
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="idclient")
	private ClientBancaire client;
	
	
	public ClientBancaire getClient() {
		return client;
	}
	public void setClient(ClientBancaire client) {
		this.client = client;
	}
	public CompteBancaire(long rib, double solde, ClientBancaire client) {
		super();
		this.rib = rib;
		this.solde = solde;
		this.client = client;
	}
	public CompteBancaire(double solde, ClientBancaire client) {
		super();
		
		this.solde = solde;
		this.client = client;
	}
	public CompteBancaire() {
		
	}
	public CompteBancaire(double solde){
		this.solde=solde;
	}
	@Override
	public String toString() {
		return "CompteBancaire [rib=" + rib + ", solde=" + solde + "]";
	}
	public long getRib() {
		return rib;
	}
	public void setRib(long rib) {
		this.rib = rib;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (rib ^ (rib >>> 32));
		long temp;
		temp = Double.doubleToLongBits(solde);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CompteBancaire other = (CompteBancaire) obj;
		if (rib != other.rib) {
			return false;
		}
		if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde)) {
			return false;
		}
		return true;
	}
	

}
