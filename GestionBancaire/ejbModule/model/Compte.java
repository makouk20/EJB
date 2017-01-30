package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the comptes database table.
 * 
 */
@Entity
@NamedQuery(name = "Compte.findAll", query = "SELECT c FROM Compte c")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int rib;

	private String nomClient;

	private float solde;

	public Compte() {
		super();
	}

	public Compte(String nomClient, float solde) {
		super();
		this.nomClient = nomClient;
		this.solde = solde;
	}

	public int getRib() {
		return rib;
	}

	public void setRib(int rib) {
		this.rib = rib;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public float getSolde() {
		return solde;
	}

	public void setSolde(float solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		return "Compte [rib=" + rib + ", nomClient=" + nomClient + ", solde=" + solde + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rib;
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
		Compte other = (Compte) obj;
		if (rib != other.rib) {
			return false;
		}
		return true;
	}

}