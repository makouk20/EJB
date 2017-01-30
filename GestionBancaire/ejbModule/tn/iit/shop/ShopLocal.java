package tn.iit.shop;

import javax.ejb.Local;

@Local
public interface ShopLocal {
	/**
	 * ajout au caddie
	 * @param nom : nom du produit à ajouter
	 * @param quantite : quantité du produit à ajouter
	 * @param prix : prix du produit à ajouter
	 */
	 void achatProduit(String nom,  int quantite, double prix);

	 /**
	  * Lister les produits sous forme d'une chaine
	  * @return : retourne la liste des produits achetés
	  */
	 String listProduitAchete();

	 boolean suppressionProduit(String produit,  int quantite);

	 double getTotal();

	 void payement(long rib);
}