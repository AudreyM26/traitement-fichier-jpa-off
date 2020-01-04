package openfoodfacts.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="INGREDIENT")

public class Ingredient extends AbstractNutriment {

	@ManyToMany(mappedBy="ingredients")
	private Set<Produit> produits = new HashSet <Produit>();

	public Ingredient() {
		super();
	}

	public Ingredient(String nom) {
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
