package tn.iit.shop;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;

import tn.iit.service.CalulatorRemote;

/**
 * Session Bean implementation class ShopBean
 */
@Stateful
@LocalBean

public class ShopBean implements ShopRemote, ShopLocal {
  

	private List<ProduitDto> listProduit = new ArrayList<>();
	//private List<String> listProduit = new ArrayList<>();
	//private List<Integer> listQuantite = new ArrayList<>();
	//private List<Double> listPrix = new ArrayList<>();
	private double total = 0;
	@EJB 
	CalulatorRemote cal ;
	
	public ShopBean() {
	}

	@Override
	public void achatProduit(String produit, int quantite, double prix) {
		/*listProduit.add(produit);
		listQuantite.add(quantite);
		listPrix.add(prix);*/
		ProduitDto pro= new ProduitDto(produit, prix, quantite);
		if (!listProduit.contains(produit)){
			listProduit.add(pro);
		}else{
			int indice=listProduit.indexOf(pro);
			listProduit.get(indice).setQuantite(listProduit.get(indice).getQuantite()+quantite);
		}
	}

	@Override
	public String listProduitAchete() {
		
		StringBuilder s = new StringBuilder();
		/*for (int i = 0; i < listPrix.size(); i++) {
			prods.append(listPrix.get(i) + " \t ");
			prods.append(listQuantite.get(i) + " \t ");
			prods.append(listProduit.get(i) + " \n ");*/
		for( ProduitDto p : listProduit){
			s.append(p.toString());
			s.append("\n");
			//s+=p.getNom()+ "\t" + p.getPrix()+"\t"+ p.getQuantite() + "\n";
		}
		return s.toString();
	}

	@Override
	public boolean suppressionProduit(String produit, int quantite) {
	/*	listProduit.remove(produit);
		listQuantite.remove(quantite);*/
		return true;
	}

	@Override
	public double getTotal() {
		total =0;
		/*for (int i = 0; i < listProduit.size(); i++) {
			total +=cal.multi(listPrix.get(i), listQuantite.get(i));
		}*/
		for( ProduitDto p : listProduit){
			total+=cal.Som(total,cal.multi(p.getPrix(),p.getQuantite()));
		}
		return total;
	}

	@Override
	public void payement(long rib) {
		// TODO Auto-generated method stub

	}
	@PostConstruct
	public void nouveauClient(){
		System.out.println("Nouveau client s'est connecté***********************************");
	}

}
