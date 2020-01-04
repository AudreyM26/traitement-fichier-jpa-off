package openfoodfacts.entites;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="PRODUIT")
@Inheritance(strategy = InheritanceType.JOINED)

public class Produit {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NOM")
	private String nom;
	
	@Column(name="SCORE_NUTRIONNEL")
	private String scoreNutrionnel;
	
	@ManyToOne 
	@JoinColumn(name="ID_CATEGORIE")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="ID_MARQUE")
	private Marque marque;
	
	@Embedded
	private ValeursNutrionnelles valeursNutrionnelles;


	@ManyToMany 
	@JoinTable(name="PROD_ADDITIF",
			joinColumns=@JoinColumn(name="ID_PRODUIT",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_ADDITIF",referencedColumnName="ID")
	)
	private Set<Additif> additifs = new HashSet <Additif>();
	
	
	@ManyToMany
	@JoinTable(name="PROD_ALLERGENE",
			joinColumns=@JoinColumn(name="ID_PRODUIT",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_ALLERGENE",referencedColumnName="ID")
	)
	private Set<Allergene> allergenes = new HashSet <Allergene>();
	
	
	@ManyToMany
	@JoinTable(name="PROD_INGREDIENT",
			joinColumns=@JoinColumn(name="ID_PRODUIT",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_INGREDIENT",referencedColumnName="ID")
	)
	private Set<Ingredient> ingredients = new HashSet <Ingredient>();
	
	
	
	public Produit(){
		super();
	}
	
	public Produit(String nom, Categorie categorie, Marque marque, String scoreNutrionnel, ValeursNutrionnelles valeursNutrionnelles,Set<Additif> additifs, Set<Allergene> allergenes,Set<Ingredient> ingredients) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.marque = marque;
		this.scoreNutrionnel = scoreNutrionnel;
		this.valeursNutrionnelles = valeursNutrionnelles;
		this.additifs = additifs;
		this.allergenes = allergenes;
		this.ingredients = ingredients;
	}
	/*
	public Produit(String nom, Categorie categorie, Marque marque, String scoreNutrionnel, List<Ingredient> ingredient, List<Allergene> allergene, List<Additif> additif, List<ValeursNutrionnelles> valeursNutrionnelles) {
		super();
		this.nom = nom;
		this.categorie = categorie;
		this.marque = marque;
		this.scoreNutrionnel = scoreNutrionnel;
		this.ingredient = ingredient;
		this.allergenes = allergene;
		this.additif = additif;
		this.valeursNutrionnelles = valeursNutrionnelles;
	}*/

	public String toString(){
		StringBuilder text = new StringBuilder();
		text.append(this.getNom()).append(" - score nutrionnel :").append(this.getScoreNutrionnel().toUpperCase());
		/*if(this.getIngredient().size() > 0){
			text.append("\n    Ingrédients:");
			for(int i=0;i<this.getIngredient().size();i++){
				
				text.append("\n     ").append(this.getIngredient().get(i).getLibelle());
			}
		}
		if(this.getValeursNutrionnelles().size() > 0){
			text.append("\n    Valeurs nutrionnelles :");
			for(int i=0;i<this.getValeursNutrionnelles().size();i++){
				
				text.append("\n     ").append(this.getValeursNutrionnelles().get(i).getLibelle());
			}
		}*/
		return text.toString();
	}
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public String getScoreNutrionnel() {
		return scoreNutrionnel;
	}

	public void setScoreNutrionnel(String scoreNutrionnel) {
		this.scoreNutrionnel = scoreNutrionnel;
	}


	public ValeursNutrionnelles getValeursNutrionnelles() {
		return valeursNutrionnelles;
	}

	public void setValeursNutrionnelles(ValeursNutrionnelles valeursNutrionnelles) {
		this.valeursNutrionnelles = valeursNutrionnelles;
	}

	/**
	 * @return the additifs
	 */
	public Set<Additif> getAdditifs() {
		return additifs;
	}

	/**
	 * @param additifs the additifs to set
	 */
	public void setAdditifs(Set<Additif> additifs) {
		this.additifs = additifs;
	}

	/**
	 * @return the allergenes
	 */
	public Set<Allergene> getAllergenes() {
		return allergenes;
	}

	/**
	 * @param allergenes the allergenes to set
	 */
	public void setAllergenes(Set<Allergene> allergenes) {
		this.allergenes = allergenes;
	}

	/**
	 * @return the ingredients
	 */
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	

	
}
