package openfoodfacts.dao;

import java.util.List;

import openfoodfacts.entites.*;

/**
 * definir les methodes pour les classes additif, allergene et ingredients
 * - extraire une liste d objets
 * - select si element existe deja dans la table
 * - creer un nouvel additif
 * - creer un nouvel allergene
 * - creer un nouvel ingredient
 * @author audrey
 *
 */

public interface NutrimentDao {

	List<Object> extraire();
	Object[] selectExist(String nom, String table);
	void insertAdditifs(Additif additif);
	void insertAllergenes(Allergene allergene);
	void insertIngredients(Ingredient ingredient);
	//int update(int nouvelleValeur);
	boolean delete();
}
