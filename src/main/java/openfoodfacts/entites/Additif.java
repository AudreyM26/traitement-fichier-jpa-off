package openfoodfacts.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ADDITIF")

public class Additif extends AbstractNutriment {

	@ManyToMany(mappedBy="additifs")
	private Set<Produit> produits = new HashSet <Produit>();
	
	public Additif() {
		super();
	}

	public Additif(String nom) {
		super();
		this.setNom(nom);
	}
	
	/**
	 * @return the produits
	 */
	public Set<Produit> getProduits() {
		return produits;
	}

	/**
	 * @param produits the produits to set
	 */
	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	
	
}
