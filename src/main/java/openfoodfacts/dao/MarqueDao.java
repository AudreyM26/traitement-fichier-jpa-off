package openfoodfacts.dao;

import java.util.List;

import openfoodfacts.entites.Marque;

/***
 * interface pour methodes a la base de données
 * - creer une marque
 * - select marque si deja existante
 * - afficher la liste des marques
 * - supprimer une marque
 * @author audrey
 *
 */
public interface MarqueDao {

	List<Marque> extraire();
	Marque selectExist(String nom);
	void insert(Marque marque);
	//int update(int nouvelleValeur);
	boolean delete();
}
