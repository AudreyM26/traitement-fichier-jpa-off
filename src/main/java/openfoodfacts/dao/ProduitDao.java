package openfoodfacts.dao;

import java.util.List;

import openfoodfacts.entites.Produit;

/***
 * définir les methodes pour la table produit
 * - lister des produits
 * - creer un nouveau produit
 * - mettre a jour un produit
 * - supprimer un produit
 * @author audrey
 *
 */
public interface ProduitDao {

	List<Produit> extraire();
	void insert(Produit produit);
	//int update(int nouvelleValeur);
	boolean delete();
}
