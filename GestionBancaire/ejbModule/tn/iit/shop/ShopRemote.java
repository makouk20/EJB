package tn.iit.shop;

import javax.ejb.Remote;

@Remote
public interface ShopRemote {
	void achatProduit(String produit, int quantite, double prix);
	String listProduitAchete();
	boolean suppressionProduit(String produit, int quantite);
	double getTotal();
	void payement(long rib);
}
