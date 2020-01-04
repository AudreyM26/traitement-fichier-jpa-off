package openfoodfacts.entites;

import javax.persistence.*;

/***
 * classe mere pour definir id et nom
 * classes filles qui vont heriter : allergene, additif et ingredients
 * @author audrey
 *
 */
@MappedSuperclass
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)

public class AbstractNutriment {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;

	@Column(name="NOM", nullable=true, length=512)
	private String nom;


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
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

	
	
}
