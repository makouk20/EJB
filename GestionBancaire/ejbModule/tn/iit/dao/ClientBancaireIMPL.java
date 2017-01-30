package tn.iit.dao;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ClientBancaire;
import model.Compte;


@Stateless(name = "Bks")
public class ClientBancaireIMPL implements ClientBancaireLocal {
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addClient(ClientBancaire client) {
		em.persist(client);
	}

	@Override
	public void removeClient(String cin) {
		em.remove(em.find(ClientBancaire.class, cin));

	}
	@Override
	public ClientBancaire getClientBancaire(String cin) {
		ClientBancaire cp = em.find(ClientBancaire.class, cin);
		if (cp == null)
			throw new RuntimeException("ClientBancaire introuvable");
         
		return cp;
	}
	@Override
	public List<ClientBancaire> ListComptes() {
		return em.createQuery("select c from ClientBancaire c", ClientBancaire.class).getResultList();
	}

	@Override
	public ClientBancaire updateClient(ClientBancaire client) {
		em.merge(client);
		return client;
		
	}

}
