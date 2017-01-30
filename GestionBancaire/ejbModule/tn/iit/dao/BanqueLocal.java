package tn.iit.dao;

import java.util.List;

import model.Compte;

public interface BanqueLocal {

	public Compte addCompte(Compte cp);

	public void removeCompte(int rib);

	public Compte getCompte(long rib);

		
	public List<Compte> ListComptes();

	public void verser(long rib, float montant);

	public void retirer(long rib, float montant);

	public void virement(long rib1, long rib2, float montant);

}
