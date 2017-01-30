package tn.iit.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.ClientBancaire;
import model.CompteBancaire;



@Singleton(name = "Bkss")

public class CompteBancaireIMPL implements CompteBancaireLocal  {
	@PersistenceContext(unitName = "comptes")
	private EntityManager em;

	@Override
	public void addCompte(CompteBancaire cp) {
		
		em.persist(cp);
	}

	@Override
	public void removeCompte(long rib) {
		em.remove(em.find(CompteBancaire.class, rib));
		
	}

	@Override
	public List<CompteBancaire> ListComptes() {
	
		return em.createQuery("select c from CompteBancaire c", CompteBancaire.class).getResultList();
	}
	@Override
	public List<CompteBancaire> ListComptesClient(ClientBancaire client) {
	
		return em.createNamedQuery("CompteBancaire.findBYClient",CompteBancaire.class).setParameter("client", client).getResultList();
	}
	@Override
	public CompteBancaire getCompte(long rib) {
		CompteBancaire cp = em.find(CompteBancaire.class, rib);
		if (cp == null)
			throw new RuntimeException("Compte introuvable");

		return cp;
	}

	@Override
	public void verser(long rib, double montant) {
		CompteBancaire cp = getCompte(rib);
		 cp.setSolde(cp.getSolde()+montant);
		
	}

	@Override
	public void retirer(long rib, double montant) {
		CompteBancaire cp = getCompte(rib);
		if (cp.getSolde() < montant)
			throw new RuntimeException("solde insuffisant");
		cp.setSolde(cp.getSolde() - montant);
		
	}

	@Override
	public void virement(long rib1, long rib2, float montant) {
		retirer(rib1, montant);
	
		verser(rib2, montant);
		
	}

	

}
