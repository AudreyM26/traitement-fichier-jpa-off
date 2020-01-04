package openfoodfacts.dao;

import java.util.List;

import openfoodfacts.entites.Categorie;

/***
 * interface pour methodes a la base de données
 * - creer une categorie
 * - select categorie si deja existante
 * - afficher la liste des categories
 * - supprimer une categorie
 * @author audrey
 *
 */
public interface CategorieDao {

	List<Categorie> extraire();
	Categorie selectExist(String nom);
	void insert(Categorie categorie);
	//int update(int nouvelleValeur);
	boolean delete();
}
