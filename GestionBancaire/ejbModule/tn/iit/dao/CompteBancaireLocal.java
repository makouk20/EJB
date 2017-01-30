package tn.iit.dao;

import java.util.List;

import model.ClientBancaire;
import model.CompteBancaire;

public interface CompteBancaireLocal {
	public void addCompte(CompteBancaire cp);

	public void removeCompte(long rib);

	public List<CompteBancaire> ListComptes();

	public CompteBancaire getCompte(long rib);

	public void verser(long rib, double montant);

	public void retirer(long rib, double montant);

	public void virement(long rib1, long rib2, float montant);
	public List<CompteBancaire> ListComptesClient(ClientBancaire client);
}
