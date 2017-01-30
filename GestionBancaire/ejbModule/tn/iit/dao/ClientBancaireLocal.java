package tn.iit.dao;

import java.util.List;

import model.ClientBancaire;

public interface ClientBancaireLocal {

	public void addClient(ClientBancaire client);

	public void removeClient(String cin);
	public ClientBancaire getClientBancaire(String cin);
	public ClientBancaire updateClient(ClientBancaire client);
	public List<ClientBancaire> ListComptes();
 
}
