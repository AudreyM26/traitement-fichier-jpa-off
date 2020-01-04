package openfoodfacts.services;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import openfoodfacts.dao.*;
import openfoodfacts.entites.*;

/****
 * parser fichier pour remplir les tables de la base de données
 * 
 * @author audrey
 *
 */
public class ParseurProduit {

	public static void ajoutLigne(HashMap<String, Integer> mapColumn, String ligne) {

		String[] morceaux = ligne.split("\\|");

		String nomProduit = morceaux[mapColumn.get("nom")];
		String scoreNutrionnel = morceaux[mapColumn.get("nutritionGradeFr")];

		// creer nouvelle categorie si non presente dans la table
		Categorie categorieProduit = new Categorie(morceaux[mapColumn.get("categorie")]);

		CategorieDaoJpa categDao = new CategorieDaoJpa();
		Categorie categ = categDao.selectExist(morceaux[mapColumn.get("categorie")]);

		if (categ == null) {
			categDao.insert(categorieProduit);
			categ = categDao.selectExist(morceaux[mapColumn.get("categorie")]);
		}

		// creer nouvelle marque si non presente dans la table
		Marque marqueProduit = new Marque(morceaux[mapColumn.get("marque")]);

		MarqueDaoJpa marqueDao = new MarqueDaoJpa();
		Marque marque = marqueDao.selectExist(morceaux[mapColumn.get("marque")]);

		if (marque == null) {
			marqueDao.insert(marqueProduit);
			marque = marqueDao.selectExist(morceaux[mapColumn.get("marque")]);
		}


		// recuperer les valeurs nutritionnelles
		Set<String> keySet = mapColumn.keySet();
		Map<String, String> mapValeursNutri = new HashMap<>();

		for (String key : keySet) {
			if (!key.equals("nom") && !key.equals("grade") && !key.equals("categorie") && !key.equals("marque")
					&& !key.equals("ingredients") && !key.equals("allergenes") && !key.equals("additifs")) {
				// association d'une clé à chaque élément
				mapValeursNutri.put(key, morceaux[mapColumn.get(key)]);
			}
		}

		ValeursNutrionnelles valNutriProduit = new ValeursNutrionnelles(mapValeursNutri);

		// creer additifs dans la table
		Set<Additif> setAdditif = new HashSet<>();

		NutrimentDaoJpa nutrimentDao = new NutrimentDaoJpa();

		if (morceaux.length > mapColumn.get("additifs")) {
			//System.out.println(morceaux[mapColumn.get("additifs")]);

			if (!morceaux[mapColumn.get("additifs")].equals("")) {
				String ingClean = morceaux[mapColumn.get("additifs")].replace("[", "").replace("]", "").toLowerCase();
				ingClean = ingClean.replaceAll("(.)[\\s+,]+(\\s+)", "$1,");
				ingClean = StringUtils.stripAccents(ingClean);
				String[] textAdditif = ingClean.split(",");
				
				Set<String> setTextAdditif = new HashSet<>();
				setTextAdditif.addAll(Arrays.asList(textAdditif));
				
				Iterator iterAdd = setTextAdditif.iterator();
				while (iterAdd.hasNext()) {
				    String textAdd = iterAdd.next().toString().trim();
				    
				    Object[] obAdditif = nutrimentDao.selectExist(textAdd, "Additif");
				    
				    if (obAdditif == null) {

						Additif additif = new Additif(textAdd);
						nutrimentDao.insertAdditifs(additif);

						obAdditif = nutrimentDao.selectExist(textAdd, "Additif");
					}

					Additif additif = new Additif(obAdditif[1].toString());
					additif.setId(Integer.parseInt(obAdditif[0].toString()));
					setAdditif.add(additif);
				    
				}
			}
		}

		// creer allergenes dans la table
		Set<Allergene> setAllergene = new HashSet<>();

		if (morceaux.length > mapColumn.get("allergenes")) {
			if (!morceaux[mapColumn.get("allergenes")].equals("")) {
				String ingClean = morceaux[mapColumn.get("allergenes")].replace("[", "").replace("]", "").toLowerCase();
				ingClean = ingClean.replaceAll("(.)[\\s+,]+(\\s+)", "$1,");
				ingClean = StringUtils.stripAccents(ingClean);
				String[] textAllergene = ingClean.split(",");
				
				Set<String> setTextAllergene = new HashSet<>();
				setTextAllergene.addAll(Arrays.asList(textAllergene));
				
				Iterator iterAll = setTextAllergene.iterator();
				while (iterAll.hasNext()) {
				    String textAll = iterAll.next().toString().trim();
				    Object[] obAllergene = nutrimentDao.selectExist(textAll, "Allergene");
				    
				    if (obAllergene == null) {

						Allergene allergene = new Allergene(textAll);
						nutrimentDao.insertAllergenes(allergene);

						obAllergene = nutrimentDao.selectExist(textAll, "Allergene");
					}

					Allergene allergene = new Allergene(obAllergene[1].toString());
					allergene.setId(Integer.parseInt(obAllergene[0].toString()));
					setAllergene.add(allergene);
				}
			}
		}

		// creer ingredient dans la table
		Set<Ingredient> setIngredient = new HashSet<>();

		if (morceaux.length > mapColumn.get("ingredients")) {
			if (!morceaux[mapColumn.get("ingredients")].equals("")) {
				//nettoyage liste avant de recuperer le contenu, remplacer les virgules des nombres décimaux par un point 
				String ingClean = morceaux[mapColumn.get("ingredients")].replaceAll("(\\d)[0-9,\\s]+(\\d)", "$1.$2");
				ingClean = ingClean.replace(")","").replace("_","").replace("*","").replace(";", ",");
				ingClean = ingClean.replaceAll("(.)[\\s+,]+(\\s+)", "$1,");
				ingClean = ingClean.replace("[", "").replace("]", "").toLowerCase();
				ingClean = StringUtils.stripAccents(ingClean);
				String[] textIngredient = ingClean.split(",");
				
				Set<String> setTextIngredient = new HashSet<>();
				setTextIngredient.addAll(Arrays.asList(textIngredient));
				
				Iterator iterIng = setTextIngredient.iterator();
				while (iterIng.hasNext()) {
				    String textIng = iterIng.next().toString().trim();
				    Object[] obIngredient = nutrimentDao.selectExist(textIng, "Ingredient");
				    
				    if (obIngredient == null) {

				    	Ingredient ingredient = new Ingredient(textIng);
						nutrimentDao.insertIngredients(ingredient);

						obIngredient = nutrimentDao.selectExist(textIng, "Ingredient");
					}

				    Ingredient ingredient = new Ingredient(obIngredient[1].toString());
				    ingredient.setId(Integer.parseInt(obIngredient[0].toString()));
				    setIngredient.add(ingredient);
				}
			}
		}
		System.out.println(morceaux.length + " " + mapColumn.get("additifs") + " " +mapColumn.get("allergenes")+"  "+ nomProduit);
		Produit produit = new Produit(nomProduit, categ, marque, scoreNutrionnel, valNutriProduit, setAdditif,setAllergene,setIngredient);

		ProduitDaoJpa produitDao = new ProduitDaoJpa();
		produitDao.insert(produit);
	}

}
