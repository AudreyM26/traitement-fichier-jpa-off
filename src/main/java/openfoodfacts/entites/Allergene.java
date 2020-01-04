package openfoodfacts.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="ALLERGENE")

public class Allergene extends AbstractNutriment {

	@ManyToMany(mappedBy="allergenes")
	private Set<Produit> produits = new HashSet <Produit>();

	public Allergene() {
		super();
	}

	public Allergene(String nom) {
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
