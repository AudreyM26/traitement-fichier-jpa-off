package openfoodfacts.entites;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="CATEGORIE")

public class Categorie {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NOM")
	private String nom;

	
	@OneToMany(mappedBy="categorie")
	private Set<Produit> produits;
	
	public Categorie() {
		super();
	}
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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
