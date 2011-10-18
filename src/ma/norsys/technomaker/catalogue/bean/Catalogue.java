/**
 * 
 */
package ma.norsys.technomaker.catalogue.bean;

import java.util.HashMap;

/**
 * @author technomaker09
 *
 */
public class Catalogue {
	private static Catalogue catalogue;
	private String nom;
	private HashMap<String, Produit> listProduit;
	
	public Catalogue() {

	}
	public static Catalogue getInstance() {
		if (null == catalogue) {
			catalogue = new Catalogue();
		}
		return catalogue;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public HashMap<String, Produit> getListProduit() {
		return listProduit;
	}

	public void setListProduit(HashMap<String, Produit> listProduit) {
		this.listProduit = listProduit;
	}

}
